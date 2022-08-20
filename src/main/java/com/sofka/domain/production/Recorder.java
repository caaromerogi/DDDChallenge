package com.sofka.domain.production;

import co.com.sofka.domain.generic.Entity;
import com.sofka.domain.production.values.Brand;
import com.sofka.domain.production.values.RecorderId;
import com.sofka.domain.production.values.Volume;

import java.util.Objects;

public class Recorder extends Entity<RecorderId> {
    private Volume volume;
    private Brand brand;


    public Recorder(RecorderId entityId, Volume volume, Brand brand) {
        super(entityId);
        this.volume = volume;
        this.brand = brand;
    }

    public void adjustVolume(Volume volume){
        this.volume = Objects.requireNonNull(volume);
    }

    public void changeBrand(Brand brand){
        this.brand = Objects.requireNonNull(brand);
    }

    public Volume volume() {
        return volume;
    }

    public Brand brand() {
        return brand;
    }
}
