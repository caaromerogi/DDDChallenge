package com.sofka.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import com.sofka.domain.song.commands.AddInstrumental;
import com.sofka.domain.song.events.InstrumentalAdded;
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
class AddInstrumentalUseCaseTest {
    private final String ROOT_ID = "1131223edfa4";

    @Mock
    private DomainEventRepository repository;

    @Test
    public void addInstrumentalUseCaseTest() {
        var command = new AddInstrumental(SongId.of(ROOT_ID), InstrumentalId.of("58689vfub"), new PercussionInstrument("Congo"), new MelodicInstrument("Guitar"), new IsRecorded(true));
        var useCase = new AddInstrumentalUseCase();

        Mockito.when(repository.getEventsBy(ROOT_ID)).thenReturn(List.of(
                new SongCreated(
                        new Title("Lonely"),
                        new ReleaseDate("04/02/1999"),
                        new IsRecorded(true)
                )
        ));
        useCase.addRepository(repository);

        var events = UseCaseHandler
                .getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(()->new IllegalArgumentException("Something went wrong adding instrumental"))
                .getDomainEvents();

        var event = (InstrumentalAdded)events.get(0);
        Assertions.assertEquals(command.getPercussionInstrument().value(), event.getPercussionInstrument().value());
        Assertions. assertEquals(command.getMelodicInstrument().value(), event.getMelodicInstrumental().value());
        Mockito.verify(repository).getEventsBy(ROOT_ID);
    }
}