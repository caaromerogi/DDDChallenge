package com.sofka.domain.production.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.domain.production.values.RecorderId;
import com.sofka.domain.production.values.Volume;

public class RecorderVolumeAdjusted extends DomainEvent {
    private final RecorderId recorderId;
    private final Volume volume;


    public RecorderVolumeAdjusted(RecorderId recorderId, Volume volume) {
        super("com.sofka.dddchallenge.Production.RecorderVolumeAdjusted");
        this.recorderId = recorderId;
        this.volume = volume;
    }

    public RecorderId getRecorderId() {
        return recorderId;
    }

    public Volume getVolume() {
        return volume;
    }
}
