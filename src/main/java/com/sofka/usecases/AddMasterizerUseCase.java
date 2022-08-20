package com.sofka.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.domain.production.Production;
import com.sofka.domain.production.commands.AddMasterizer;

public class AddMasterizerUseCase extends UseCase<RequestCommand<AddMasterizer>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddMasterizer> addMasterizerRequestCommand) {
        var command = addMasterizerRequestCommand.getCommand();
        var production = Production.from(command.getProductionId(), retrieveEvents(command.getProductionId().value()));
        production.addMasterizer(command.getMasterizerId(), command.getEqualizer(), command.getCompressor());
        emit().onResponse(new ResponseEvents(production.getUncommittedChanges()));
    }
}
