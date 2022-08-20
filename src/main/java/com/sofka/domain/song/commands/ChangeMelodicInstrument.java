package com.sofka.domain.song.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.domain.song.values.InstrumentalId;
import com.sofka.domain.song.values.MelodicInstrument;
import com.sofka.domain.song.values.SongId;

public class ChangeMelodicInstrument extends Command {
    private final SongId songId;
    private final InstrumentalId instrumentalId;
    private final MelodicInstrument melodicInstrument;


    public ChangeMelodicInstrument(SongId songId, InstrumentalId instrumentalId, MelodicInstrument melodicInstrument) {
        this.songId = songId;
        this.instrumentalId = instrumentalId;
        this.melodicInstrument = melodicInstrument;
    }

    public SongId getSongId() {
        return songId;
    }

    public InstrumentalId getInstrumentalId() {
        return instrumentalId;
    }

    public MelodicInstrument getMelodicInstrument() {
        return melodicInstrument;
    }
}
