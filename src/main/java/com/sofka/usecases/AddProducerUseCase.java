package com.sofka.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.domain.production.Production;
import com.sofka.domain.production.commands.AddProducer;

public class AddProducerUseCase extends UseCase<RequestCommand<AddProducer>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddProducer> addProducerRequestCommand) {
        var command = addProducerRequestCommand.getCommand();
        var production = Production.from(command.getProductionId(), retrieveEvents(command.getProductionId().value()));
        production.addProducer(command.getProducerId(), command.getName(), command.getSign());
        emit().onResponse(new ResponseEvents(production.getUncommittedChanges()));
    }
}
