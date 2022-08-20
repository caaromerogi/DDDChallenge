package com.sofka.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.domain.song.Song;
import com.sofka.domain.song.commands.CreateSong;
import com.sofka.domain.song.values.IsRecorded;

public class CreateSongUseCase extends UseCase<RequestCommand<CreateSong>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CreateSong> createSongRequestCommand) {
        CreateSong createSong = createSongRequestCommand.getCommand();
        Song song = new Song(createSong.getSongId(), createSong.getReleaseDate(), createSong.getTitle(), new IsRecorded(false));
        emit().onResponse(new ResponseEvents(song.getUncommittedChanges()));
    }
}
