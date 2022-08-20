package com.sofka.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.domain.song.Song;
import com.sofka.domain.song.commands.ChangeMelodicInstrument;

public class ChangeMelodicInstrumentUseCase extends UseCase<RequestCommand<ChangeMelodicInstrument>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ChangeMelodicInstrument> changeMelodicInstrumentRequestCommand) {
        var command = changeMelodicInstrumentRequestCommand.getCommand();
        var song = Song.from(command.getSongId(), retrieveEvents(command.getSongId().value()));
        song.changeMelodicInstrument(command.getInstrumentalId(), command.getMelodicInstrument());
        emit().onResponse(new ResponseEvents(song.getUncommittedChanges()));

    }
}
