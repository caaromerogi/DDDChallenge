package com.sofka.domain.song.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.domain.song.values.InstrumentalId;
import com.sofka.domain.song.values.MelodicInstrument;

public class MelodicInstrumentChanged extends DomainEvent {
    private final InstrumentalId instrumentalId;
    private final MelodicInstrument melodicInstrument;


    public MelodicInstrumentChanged(InstrumentalId instrumentalId, MelodicInstrument melodicInstrument) {
        super("com.sofka.dddchallenge.Song.MelodicInstrumentChanged");
        this.instrumentalId = instrumentalId;
        this.melodicInstrument = melodicInstrument;
    }

    public InstrumentalId getInstrumentalId() {
        return instrumentalId;
    }

    public MelodicInstrument getMelodicInstrument() {
        return melodicInstrument;
    }
}
