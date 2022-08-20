package com.sofka.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.domain.song.Song;
import com.sofka.domain.song.commands.AddSinger;
import com.sofka.domain.song.values.IsRecorded;

public class AddSingerUseCase extends UseCase<RequestCommand<AddSinger>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddSinger> addSingerRequestCommand) {
        var command = addSingerRequestCommand.getCommand();
        var song = Song.from(command.getSongId(), retrieveEvents(command.getSongId().value()));
        song.addSinger(command.getSingerId(), command.getName(), command.getVocalRegister(), new IsRecorded(false));

        emit().onResponse(new ResponseEvents(song.getUncommittedChanges()));
    }
}
