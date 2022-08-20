package com.sofka.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.domain.production.Production;
import com.sofka.domain.production.commands.CreateProduction;

public class CreateProductionUseCase extends UseCase<RequestCommand<CreateProduction>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CreateProduction> createProductionRequestCommand) {
        CreateProduction createProduction = createProductionRequestCommand.getCommand();
        Production production = new Production(createProduction.getProductionId(),createProduction.getSongId());
        emit().onResponse(new ResponseEvents(production.getUncommittedChanges()));
    }
}
