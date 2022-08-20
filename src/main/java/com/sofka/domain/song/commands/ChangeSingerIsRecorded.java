package com.sofka.domain.song.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.domain.song.values.IsRecorded;
import com.sofka.domain.song.values.SingerId;
import com.sofka.domain.song.values.SongId;

public class ChangeSingerIsRecorded extends Command {
    private final SongId songId;
    private final SingerId singerId;
    private final IsRecorded isRecorded;


    public ChangeSingerIsRecorded(SongId songId, SingerId singerId, IsRecorded isRecorded) {
        this.songId = songId;
        this.singerId = singerId;
        this.isRecorded = isRecorded;
    }

    public SongId getSongId() {
        return songId;
    }

    public SingerId getSingerId() {
        return singerId;
    }

    public IsRecorded getIsRecorded() {
        return isRecorded;
    }
}
