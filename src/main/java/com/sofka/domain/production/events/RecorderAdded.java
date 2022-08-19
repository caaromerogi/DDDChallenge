package com.sofka.domain.production.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.domain.production.values.RecorderId;

public class RecorderAdded extends DomainEvent {
    private final RecorderId recorderId;


    public RecorderAdded(RecorderId recorderId) {
        super("com.sofka.dddchallenge.Production.RecorderAdded");
        this.recorderId = recorderId;
    }

    public RecorderId getRecorderId() {
        return recorderId;
    }
}
