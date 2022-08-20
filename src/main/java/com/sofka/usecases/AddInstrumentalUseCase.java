package com.sofka.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.domain.song.Song;
import com.sofka.domain.song.commands.AddInstrumental;
import com.sofka.domain.song.values.IsRecorded;

public class AddInstrumentalUseCase extends UseCase<RequestCommand<AddInstrumental>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddInstrumental> addInstrumentalRequestCommand) {
        var command = addInstrumentalRequestCommand.getCommand();
        var song = Song.from(command.getSongId(), retrieveEvents(command.getSongId().value()));
        song.addInstrumental(command.getInstrumentalId(), command.getPercussionInstrument(), command.getMelodicInstrument(), new IsRecorded(false));
        emit().onResponse(new ResponseEvents(song.getUncommittedChanges()));
    }


}
