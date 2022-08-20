package com.sofka.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.domain.production.Production;
import com.sofka.domain.production.commands.AddRecorder;

public class AddRecorderUseCase extends UseCase<RequestCommand<AddRecorder>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddRecorder> addRecorderRequestCommand) {
        var command =addRecorderRequestCommand.getCommand();
        var production = Production.from(command.getProductionId(), retrieveEvents(command.getProductionId().value()));
        production.addRecorder(command.getRecorderId(), command.getVolume(), command.getBrand());
        emit().onResponse(new ResponseEvents(production.getUncommittedChanges()));
    }
}
