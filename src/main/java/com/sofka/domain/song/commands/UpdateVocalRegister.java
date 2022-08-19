package com.sofka.domain.song.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.domain.song.values.SingerId;
import com.sofka.domain.song.values.SongId;
import com.sofka.domain.song.values.VocalRegister;

public class UpdateVocalRegister extends Command {
    private final SongId songId;
    private final SingerId singerId;
    private final VocalRegister vocalRegister;


    public UpdateVocalRegister(SongId songId, SingerId singerId, VocalRegister vocalRegister) {
        this.songId = songId;
        this.singerId = singerId;
        this.vocalRegister = vocalRegister;
    }

    public SongId getSongId() {
        return songId;
    }

    public SingerId getSingerId() {
        return singerId;
    }

    public VocalRegister getVocalRegister() {
        return vocalRegister;
    }
}
