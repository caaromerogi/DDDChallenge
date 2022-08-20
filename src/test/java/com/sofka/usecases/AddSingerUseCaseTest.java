package com.sofka.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import com.sofka.domain.generics.Name;
import com.sofka.domain.song.Singer;
import com.sofka.domain.song.commands.AddSinger;
import com.sofka.domain.song.events.SingerAdded;
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
class AddSingerUseCaseTest {
    private final String ROOT_ID = "908070";

    @Mock
    private DomainEventRepository repository;

    @Test
    public void addSingerUseCaseTest(){
        var command = new AddSinger(SongId.of(ROOT_ID), SingerId.of("121314"), new Name("Herrera"), new VocalRegister("Tenor"));
        var useCase = new AddSingerUseCase();

        Mockito.when(repository.getEventsBy(ROOT_ID)).thenReturn(List.of(
                new SongCreated(
                        new Title("23"),
                        new ReleaseDate("21/10/2022")
                )
        ));

        useCase.addRepository(repository);

        var events = UseCaseHandler
                .getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(()->new IllegalArgumentException("Something went wrong adding singer"))
                .getDomainEvents();

        var event = (SingerAdded)events.get(0);
        Assertions.assertEquals(command.getName().value(),event.getName().value());
        Mockito.verify(repository).getEventsBy(ROOT_ID);

    }

}