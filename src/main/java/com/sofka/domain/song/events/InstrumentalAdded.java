package com.sofka.domain.song.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.domain.song.values.InstrumentalId;
import com.sofka.domain.song.values.IsRecorded;
import com.sofka.domain.song.values.MelodicInstrument;
import com.sofka.domain.song.values.PercussionInstrument;

public class InstrumentalAdded extends DomainEvent {
    private final InstrumentalId instrumentalId;
    private final PercussionInstrument percussionInstrument;
    private final MelodicInstrument melodicInstrumental;

    private final IsRecorded isRecorded;


    public InstrumentalAdded(InstrumentalId instrumentalId,
                             PercussionInstrument percussionInstrument,
                             MelodicInstrument melodicInstrumental,
                             IsRecorded isRecorded) {
        super("com.sofka.dddchallenge.Song.InstrumentalAdded");
        this.instrumentalId = instrumentalId;
        this.percussionInstrument = percussionInstrument;
        this.melodicInstrumental = melodicInstrumental;
        this.isRecorded = isRecorded;
    }

    public InstrumentalId getInstrumentalId() {
        return instrumentalId;
    }

    public PercussionInstrument getPercussionInstrument() {
        return percussionInstrument;
    }

    public MelodicInstrument getMelodicInstrumental() {
        return melodicInstrumental;
    }

    public IsRecorded getIsRecorded() {
        return isRecorded;
    }
}
