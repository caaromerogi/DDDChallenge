package com.sofka.domain.production.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.domain.production.values.Brand;
import com.sofka.domain.production.values.RecorderId;

public class RecorderBrandChanged extends DomainEvent {
    private final RecorderId recorderId;
    private final Brand brand;


    public RecorderBrandChanged(RecorderId recorderId, Brand brand) {
        super("com.sofka.dddchallenge.Production.RecorderBrandChanged");
        this.recorderId = recorderId;
        this.brand = brand;
    }

    public RecorderId getRecorderId() {
        return recorderId;
    }

    public Brand getBrand() {
        return brand;
    }
}
