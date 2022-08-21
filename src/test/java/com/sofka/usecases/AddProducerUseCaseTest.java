package com.sofka.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import com.sofka.domain.generics.Name;
import com.sofka.domain.production.commands.AddProducer;
import com.sofka.domain.production.events.ProducerAdded;
import com.sofka.domain.production.events.ProductionCreated;
import com.sofka.domain.production.values.IsFinished;
import com.sofka.domain.production.values.ProducerId;
import com.sofka.domain.production.values.ProductionId;
import com.sofka.domain.production.values.Sign;
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
class AddProducerUseCaseTest {
    private final String ROOT_ID = "31234";

    @Mock
    private DomainEventRepository repository;

    @Test
    public void addProducerUseCaseTest(){
        var command = new AddProducer(ProductionId.of(ROOT_ID), ProducerId.of("3214124f"), new Name("Tiny"), new Sign("Hear this music"));
        var useCase = new AddProducerUseCase();
        Mockito.when(repository.getEventsBy(ROOT_ID)).thenReturn(List.of(
                new ProductionCreated(new SongId(), new IsFinished(false))
        ));

        useCase.addRepository(repository);
        var events = UseCaseHandler
                .getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(()->new IllegalArgumentException("Something went wrong adding producer"))
                .getDomainEvents();

        var event = (ProducerAdded)events.get(0);
        Assertions.assertEquals(command.getName().value(), event.getName().value());
        Assertions.assertEquals(command.getSign().value(), event.getSign().value());
        Mockito.verify(repository).getEventsBy(ROOT_ID);

    }

}