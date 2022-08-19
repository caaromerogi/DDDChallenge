package com.sofka.domain.song.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.domain.song.values.InstrumentalId;
import com.sofka.domain.song.values.SongId;

public class ChangeMelodicInstrument extends Command {
    private final SongId songId;
    private final InstrumentalId instrumentalId;
    private final ChangeMelodicInstrument changeMelodicInstrumentalId;


    public ChangeMelodicInstrument(SongId songId, InstrumentalId instrumentalId, ChangeMelodicInstrument changeMelodicInstrumentalId) {
        this.songId = songId;
        this.instrumentalId = instrumentalId;
        this.changeMelodicInstrumentalId = changeMelodicInstrumentalId;
    }

    public SongId getSongId() {
        return songId;
    }

    public InstrumentalId getInstrumentalId() {
        return instrumentalId;
    }

    public ChangeMelodicInstrument getChangeMelodicInstrumentalId() {
        return changeMelodicInstrumentalId;
    }
}
