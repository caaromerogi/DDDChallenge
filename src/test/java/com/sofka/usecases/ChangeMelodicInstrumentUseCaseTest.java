package com.sofka.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import com.sofka.domain.song.commands.ChangeMelodicInstrument;
import com.sofka.domain.song.events.InstrumentalAdded;
import com.sofka.domain.song.events.MelodicInstrumentChanged;
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
class ChangeMelodicInstrumentUseCaseTest {
    private final String ROOT_ID = "31234";

    @Mock
    private DomainEventRepository repository;

    @Test
    public void changeMelodicInstrumentUseCaseTest(){
        var command = new ChangeMelodicInstrument(SongId.of(ROOT_ID), InstrumentalId.of("f2dhbusv32"), new MelodicInstrument("Drum pad"));
        var useCase = new ChangeMelodicInstrumentUseCase();
        Mockito.when(repository.getEventsBy(ROOT_ID)).thenReturn(List.of(
                new SongCreated(
                        new Title("La Plata"),
                        new ReleaseDate("12/12/2002"),
                        new IsRecorded(true)
                ),
                new InstrumentalAdded(
                        InstrumentalId.of("f2dhbusv32"),
                        new PercussionInstrument("Drums"),
                        new MelodicInstrument("Guitar"),
                        new IsRecorded(true)
                )
        ));
        useCase.addRepository(repository);
        var events = UseCaseHandler
                .getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(()->new IllegalArgumentException("Something went wrong changing melodic instrument"))
                .getDomainEvents();

        var event = (MelodicInstrumentChanged)events.get(0);
        Assertions.assertEquals(command.getMelodicInstrument().value(), event.getMelodicInstrument().value());
        Mockito.verify(repository).getEventsBy(ROOT_ID);

    }


}