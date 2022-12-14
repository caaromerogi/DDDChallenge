package com.sofka.domain.production.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.domain.production.values.Brand;
import com.sofka.domain.production.values.RecorderId;
import com.sofka.domain.production.values.Volume;

public class RecorderAdded extends DomainEvent {
    private final RecorderId recorderId;
    private final Volume volume;
    private final Brand brand;


    public RecorderAdded(RecorderId recorderId, Volume volume, Brand brand) {
        super("com.sofka.dddchallenge.Production.RecorderAdded");
        this.recorderId = recorderId;
        this.volume = volume;
        this.brand = brand;
    }

    public RecorderId getRecorderId() {
        return recorderId;
    }

    public Volume getVolume() {
        return volume;
    }

    public Brand getBrand() {
        return brand;
    }
}
