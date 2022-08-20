package com.sofka.domain.song.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.domain.song.values.InstrumentalId;
import com.sofka.domain.song.values.IsRecorded;
import com.sofka.domain.song.values.SongId;

public class ChangeInstrumentalIsRecorded extends Command {
    private final SongId songId;
    private final InstrumentalId instrumentalId;
    private final IsRecorded isRecorded;


    public ChangeInstrumentalIsRecorded(SongId songId, InstrumentalId instrumentalId, IsRecorded isRecorded) {
        this.songId = songId;
        this.instrumentalId = instrumentalId;
        this.isRecorded = isRecorded;
    }

    public SongId getSongId() {
        return songId;
    }

    public InstrumentalId getInstrumentalId() {
        return instrumentalId;
    }

    public IsRecorded getIsRecorded() {
        return isRecorded;
    }
}
