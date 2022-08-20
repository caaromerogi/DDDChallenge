package com.sofka.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.domain.song.Song;
import com.sofka.domain.song.commands.UpdateVocalRegister;

public class UpdateVocalRegisterUseCase extends UseCase<RequestCommand<UpdateVocalRegister>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdateVocalRegister> updateVocalRegisterRequestCommand) {
        var command = updateVocalRegisterRequestCommand.getCommand();
        var song = Song.from(command.getSongId(), retrieveEvents(command.getSongId().value()));
        song.updateVocalRegister(command.getSingerId(), command.getVocalRegister());
        emit().onResponse(new ResponseEvents(song.getUncommittedChanges()));
    }
}
