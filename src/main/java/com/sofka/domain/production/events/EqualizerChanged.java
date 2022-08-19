package com.sofka.domain.production.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.domain.production.values.Equalizer;
import com.sofka.domain.production.values.MasterizerId;

public class EqualizerChanged extends DomainEvent {
    private final MasterizerId masterizerId;
    private final Equalizer equalizer;


    public EqualizerChanged(MasterizerId masterizerId, Equalizer equalizer) {
        super("com.sofka.dddchallenge.Production.EqualizerChanged");
        this.masterizerId = masterizerId;
        this.equalizer = equalizer;
    }

    public MasterizerId getMasterizerId() {
        return masterizerId;
    }

    public Equalizer getEqualizer() {
        return equalizer;
    }
}
