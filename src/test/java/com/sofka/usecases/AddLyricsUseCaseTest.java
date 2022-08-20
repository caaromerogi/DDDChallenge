package com.sofka.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import com.sofka.domain.song.commands.AddLyrics;
import com.sofka.domain.song.events.LyricsAdded;
import com.sofka.domain.song.events.SongCreated;
import com.sofka.domain.song.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class AddLyricsUseCaseTest {
    private final String ROOT_ID = "908070";

    @Mock
    private DomainEventRepository repository;

    @Test
    public void addLyricsUseCaseTest(){
        var command = new AddLyrics(SongId.of(ROOT_ID), LyricsId.of("432556tn"), new Chorus("Hello darkness my old friend"), new Verse("La la la"));
        var useCase = new AddLyricsUseCase();

        Mockito.when(repository.getEventsBy(ROOT_ID)).thenReturn(List.of(
                new SongCreated(
                        new Title("Disturbed"),
                        new ReleaseDate("03/01/2002"),
                        new IsRecorded(true)
                )
        ));
        useCase.addRepository(repository);

        var events = UseCaseHandler
                .getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(()->new IllegalArgumentException("Something went wrong adding lyrics"))
                .getDomainEvents();

        var event = (LyricsAdded)events.get(0);

        Assertions.assertEquals(command.getChorus().value(), event.getChorus().value());
        Assertions.assertEquals(command.getVerse().value(), event.getVerse().value());
        Mockito.verify(repository).getEventsBy(ROOT_ID);

    }
}