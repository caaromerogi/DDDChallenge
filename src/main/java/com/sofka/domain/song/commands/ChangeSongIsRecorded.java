package com.sofka.domain.song.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.domain.song.values.IsRecorded;
import com.sofka.domain.song.values.SongId;

public class ChangeSongIsRecorded extends Command {
    private final SongId songId;
    private final IsRecorded isRecorded;

    public ChangeSongIsRecorded(SongId songId, IsRecorded isRecorded) {
        this.songId = songId;
        this.isRecorded = isRecorded;
    }

    public SongId getSongId() {
        return songId;
    }

    public IsRecorded getIsRecorded() {
        return isRecorded;
    }
}
