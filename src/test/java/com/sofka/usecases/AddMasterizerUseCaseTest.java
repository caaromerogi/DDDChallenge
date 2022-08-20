package com.sofka.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import com.sofka.domain.production.commands.AddMasterizer;
import com.sofka.domain.production.events.MasterizerAdded;
import com.sofka.domain.production.events.ProductionCreated;
import com.sofka.domain.production.values.Compressor;
import com.sofka.domain.production.values.Equalizer;
import com.sofka.domain.production.values.MasterizerId;
import com.sofka.domain.production.values.ProductionId;
import com.sofka.domain.song.values.SongId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class AddMasterizerUseCaseTest {
    private final String ROOT_ID = "3434dsf";

    @Mock
    private DomainEventRepository repository;

    @Test
    public void addMasterizerUseCaseTest() {
        var command = new AddMasterizer(ProductionId.of(ROOT_ID), MasterizerId.of("231321fsdc"), new Equalizer("Fruit1202"), new Compressor("FruitCompressor1201"));
        var useCase = new AddMasterizerUseCase();

        Mockito.when(repository.getEventsBy(ROOT_ID)).thenReturn(List.of(
                new ProductionCreated(new SongId())
        ));
        useCase.addRepository(repository);
        var events = UseCaseHandler
                .getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(()->new IllegalArgumentException("Something went wrong adding masterizer"))
                .getDomainEvents();

        var event = (MasterizerAdded)events.get(0);

        Assertions.assertEquals(command.getEqualizer().value(), event.getEqualizer().value());
        Assertions.assertEquals(command.getCompressor().value(), event.getCompressor().value());
        Mockito.verify(repository).getEventsBy(ROOT_ID);

    }
}