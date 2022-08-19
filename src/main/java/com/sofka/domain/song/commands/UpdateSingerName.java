package com.sofka.domain.song.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.domain.generics.Name;
import com.sofka.domain.song.values.SingerId;
import com.sofka.domain.song.values.SongId;

public class UpdateSingerName extends Command {

    private final SongId songId;

    private final SingerId singerId;

    private final Name name;

    public UpdateSingerName(SongId songId, SingerId singerId, Name name) {
        this.songId = songId;
        this.singerId = singerId;
        this.name = name;
    }

    public SongId getSongId() {
        return songId;
    }

    public SingerId getSingerId() {
        return singerId;
    }

    public Name getName() {
        return name;
    }
}
