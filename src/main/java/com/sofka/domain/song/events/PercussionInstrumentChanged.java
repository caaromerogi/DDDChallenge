package com.sofka.domain.song.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.domain.song.values.InstrumentalId;
import com.sofka.domain.song.values.PercussionInstrument;

public class PercussionInstrumentChanged extends DomainEvent {
    private final InstrumentalId instrumentalId;
    private final PercussionInstrument percussionInstrument;


    public PercussionInstrumentChanged(InstrumentalId instrumentalId, PercussionInstrument percussionInstrument) {
        super("com.sofka.dddchallenge.PercussionInstrumentChanged");
        this.instrumentalId = instrumentalId;
        this.percussionInstrument = percussionInstrument;
    }

    public InstrumentalId getInstrumentalId() {
        return instrumentalId;
    }

    public PercussionInstrument getPercussionInstrument() {
        return percussionInstrument;
    }
}
