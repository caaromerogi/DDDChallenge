package com.sofka.domain.song;

import co.com.sofka.domain.generic.Entity;
import com.sofka.domain.song.values.InstrumentalId;
import com.sofka.domain.song.values.IsRecorded;
import com.sofka.domain.song.values.MelodicInstrument;
import com.sofka.domain.song.values.PercussionInstrument;

import java.util.Objects;

public class Instrumental extends Entity<InstrumentalId> {

    private PercussionInstrument percussionInstrument;

    private MelodicInstrument melodicInstrument;

    private IsRecorded isRecorded;

    public Instrumental(InstrumentalId entityId,
                        PercussionInstrument percussionInstrument,
                        MelodicInstrument melodicInstrument,
                        IsRecorded isRecorded) {
        super(entityId);
        this.percussionInstrument = percussionInstrument;
        this.melodicInstrument = melodicInstrument;
        this.isRecorded = isRecorded;
    }

    public void changePercussionInstrument(PercussionInstrument percussionInstrument){
        this.percussionInstrument = Objects.requireNonNull(percussionInstrument);
    }

    public void changeMelodicInstrument(MelodicInstrument melodicInstrument){
        this.melodicInstrument = Objects.requireNonNull(melodicInstrument);
    }

    public void recordInstrumental(IsRecorded isRecorded){
        this.isRecorded = Objects.requireNonNull(isRecorded);
    }

    public PercussionInstrument percussionInstrument() {
        return percussionInstrument;
    }

    public MelodicInstrument melodicInstrument() {
        return melodicInstrument;
    }

    public IsRecorded isRecorded(){
        return isRecorded;
    }
}
