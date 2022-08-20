package com.sofka.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.domain.song.Song;
import com.sofka.domain.song.commands.CreateSong;

public class CreateSongUseCase extends UseCase<RequestCommand<CreateSong>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CreateSong> createSongRequestCommand) {
        CreateSong createSong = createSongRequestCommand.getCommand();
        Song song = new Song(createSong.getSongId(), createSong.getReleaseDate(), createSong.getTitle(), createSong.getIsRecorded());
        emit().onResponse(new ResponseEvents(song.getUncommittedChanges()));
    }
}
