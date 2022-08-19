package com.sofka.domain.song;

import co.com.sofka.domain.generic.Entity;
import com.sofka.domain.song.values.InstrumentalId;
import com.sofka.domain.song.values.MelodicInstrument;
import com.sofka.domain.song.values.PercussionInstrument;

import java.util.Objects;

public class Instrumental extends Entity<InstrumentalId> {

    private PercussionInstrument percussionInstrument;

    private MelodicInstrument melodicInstrument;

    public Instrumental(InstrumentalId entityId, PercussionInstrument percussionInstrument, MelodicInstrument melodicInstrument) {
        super(entityId);
        this.percussionInstrument = percussionInstrument;
        this.melodicInstrument = melodicInstrument;
    }

    public void changePercussionInstrument(PercussionInstrument percussionInstrument){
        this.percussionInstrument = Objects.requireNonNull(percussionInstrument);
    }

    public void changeMelodicInstrument(MelodicInstrument melodicInstrument){
        this.melodicInstrument = Objects.requireNonNull(melodicInstrument);
    }

    public PercussionInstrument percussionInstrument() {
        return percussionInstrument;
    }

    public MelodicInstrument melodicInstrument() {
        return melodicInstrument;
    }
}
