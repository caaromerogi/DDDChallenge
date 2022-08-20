package com.sofka.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.domain.song.Song;
import com.sofka.domain.song.commands.AddLyrics;

public class AddLyricsUseCase extends UseCase<RequestCommand<AddLyrics>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddLyrics> addLyricsRequestCommand) {
        var command = addLyricsRequestCommand.getCommand();
        var song = Song.from(command.getSongId(), retrieveEvents(command.getSongId().value()));
        song.addLyrics(command.getLyricsId(),command.getChorus(), command.getVerse());
        emit().onResponse(new ResponseEvents(song.getUncommittedChanges()));

    }
}
