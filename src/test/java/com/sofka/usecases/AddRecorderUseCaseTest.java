package com.sofka.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import com.sofka.domain.production.Production;
import com.sofka.domain.production.commands.AddRecorder;
import com.sofka.domain.production.events.ProductionCreated;
import com.sofka.domain.production.events.RecorderAdded;
import com.sofka.domain.production.values.Brand;
import com.sofka.domain.production.values.ProductionId;
import com.sofka.domain.production.values.RecorderId;
import com.sofka.domain.production.values.Volume;
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
class AddRecorderUseCaseTest {
    private final String ROOT_ID = "908070";

    @Mock
    private DomainEventRepository repository;
    @Test
    public void addRecorderUseCaseTest(){
        var command = new AddRecorder(ProductionId.of(ROOT_ID), RecorderId.of("1321321"), new Volume("50"), new Brand("Shure"));
        var useCase = new AddRecorderUseCase();

        Mockito.when(repository.getEventsBy(ROOT_ID)).thenReturn(List.of(
                new ProductionCreated(new SongId())
        ));
        useCase.addRepository(repository);

        var events = UseCaseHandler
                .getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(()->new IllegalArgumentException("Something went wrong adding recorder"))
                .getDomainEvents();

        var event = (RecorderAdded)events.get(0);
        Assertions.assertEquals(command.getVolume().value(), event.getVolume().value());
        Assertions.assertEquals(command.getBrand().value(), event.getBrand().value());
        Mockito.verify(repository).getEventsBy(ROOT_ID);

    }
}