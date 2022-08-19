package com.sofka.domain.song.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.domain.generics.Name;
import com.sofka.domain.song.values.SingerId;
import com.sofka.domain.song.values.SongId;
import com.sofka.domain.song.values.VocalRegister;

public class AddSinger extends Command {

    private final SongId songId;

    private final SingerId singerId;

    private final Name name;

    private final VocalRegister vocalRegister;

    public AddSinger(SongId songId, SingerId singerId, Name name, VocalRegister vocalRegister) {
        this.songId = songId;
        this.singerId = singerId;
        this.name = name;
        this.vocalRegister = vocalRegister;
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

    public VocalRegister getVocalRegister() {
        return vocalRegister;
    }
}
