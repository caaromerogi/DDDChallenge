package com.sofka.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import com.sofka.domain.generics.Name;
import com.sofka.domain.song.commands.UpdateVocalRegister;
import com.sofka.domain.song.events.SingerAdded;
import com.sofka.domain.song.events.SongCreated;
import com.sofka.domain.song.events.VocalRegisterUpdated;
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
class UpdateVocalRegisterUseCaseTest {
    private final String ROOT_ID = "9569juf";

    @Mock
    private DomainEventRepository repository;

    @Test
    public void updateVocalRegisterUseCaseTest() {
        var command = new UpdateVocalRegister(SongId.of(ROOT_ID), SingerId.of("301nfsh"), new VocalRegister("Barítono"));
        var useCase = new UpdateVocalRegisterUseCase();

        Mockito.when(repository.getEventsBy(ROOT_ID)).thenReturn(List.of(
                new SongCreated(
                        new Title("La Plata"),
                        new ReleaseDate("12/12/2002"),
                        new IsRecorded(true)
                ),
                new SingerAdded(
                        SingerId.of("301nfsh"),
                        new Name("Diomedes Diaz"),
                        new VocalRegister("Bajo"),
                        new IsRecorded(true)
                )
        ));

        useCase.addRepository(repository);

        var events = UseCaseHandler
                .getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(()->new IllegalArgumentException("Something went wrong updating vocal register instrument"))
                .getDomainEvents();

        var event = (VocalRegisterUpdated)events.get(0);
        Assertions.assertEquals(command.getVocalRegister().value(), event.getVocalRegister().value());
        Mockito.verify(repository).getEventsBy(ROOT_ID);

    }
}