package com.sofka.domain.song.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.domain.song.values.InstrumentalId;
import com.sofka.domain.song.values.MelodicInstrument;
import com.sofka.domain.song.values.PercussionInstrument;
import com.sofka.domain.song.values.SongId;

public class AddInstrumental extends Command {

    private final SongId songId;

    private final InstrumentalId instrumentalId;

    private final PercussionInstrument percussionInstrument;

    private final MelodicInstrument melodicInstrument;

    public AddInstrumental(SongId songId, InstrumentalId instrumentalId, PercussionInstrument percussionInstrument, MelodicInstrument melodicInstrument) {
        this.songId = songId;
        this.instrumentalId = instrumentalId;
        this.percussionInstrument = percussionInstrument;
        this.melodicInstrument = melodicInstrument;
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

    public MelodicInstrument getMelodicInstrument() {
        return melodicInstrument;
    }
}
