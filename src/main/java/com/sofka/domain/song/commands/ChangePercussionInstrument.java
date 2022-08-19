package com.sofka.domain.song.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.domain.song.values.InstrumentalId;
import com.sofka.domain.song.values.PercussionInstrument;
import com.sofka.domain.song.values.SongId;

public class ChangePercussionInstrument extends Command {
    private final SongId songId;
    private final InstrumentalId instrumentalId;
    private final PercussionInstrument percussionInstrument;


    public ChangePercussionInstrument(SongId songId, InstrumentalId instrumentalId, PercussionInstrument percussionInstrument) {
        this.songId = songId;
        this.instrumentalId = instrumentalId;
        this.percussionInstrument = percussionInstrument;
    }

    public SongId getSongId() {
        return songId;
    }

    public InstrumentalId getInstrumentalId() {
        return instrumentalId;
    }

    public PercussionInstrument getPercussionInstrument() {
        return percussionInstrument;
    }
}
