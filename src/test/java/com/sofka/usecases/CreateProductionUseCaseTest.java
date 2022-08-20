package com.sofka.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import com.sofka.domain.production.commands.CreateProduction;
import com.sofka.domain.production.events.ProductionCreated;
import com.sofka.domain.song.values.SongId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CreateProductionUseCaseTest {

    @Test
    public void createProductionUseCaseTest(){

        CreateProduction command = new CreateProduction(new SongId());
        CreateProductionUseCase useCase = new CreateProductionUseCase();

        var events = UseCaseHandler
                .getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(()->new IllegalArgumentException("Something went wrong creating production"))
                .getDomainEvents();

        ProductionCreated event = (ProductionCreated) events.get(0);

        Assertions.assertEquals(command.getSongId(),event.getSongId());

    }

}