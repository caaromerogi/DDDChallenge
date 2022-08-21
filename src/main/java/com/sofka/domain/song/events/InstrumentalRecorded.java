package com.sofka.domain.song.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.domain.song.values.InstrumentalId;
import com.sofka.domain.song.values.IsRecorded;

public class InstrumentalRecorded extends DomainEvent {
    private final InstrumentalId instrumentalId;
    private final IsRecorded isRecorded;

    public InstrumentalRecorded(InstrumentalId instrumentalId, IsRecorded isRecorded) {
        super("com.sofka.dddchallenge.Song.InstrumentalIsRecordedChanged");
        this.instrumentalId = instrumentalId;
        this.isRecorded = isRecorded;
    }

    public InstrumentalId getInstrumentalId() {
        return instrumentalId;
    }

    public IsRecorded getIsRecorded() {
        return isRecorded;
    }
}
