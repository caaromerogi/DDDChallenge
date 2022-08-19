package com.sofka.domain.production.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.domain.production.values.Compressor;
import com.sofka.domain.production.values.Equalizer;
import com.sofka.domain.production.values.MasterizerId;

public class MasterizerAdded extends DomainEvent {
    private final MasterizerId masterizerId;
    private final Equalizer equalizer;
    private final Compressor compressor;


    public MasterizerAdded(MasterizerId masterizerId, Equalizer equalizer, Compressor compressor) {
        super("com.sofka.dddchallenge.Production.MasterizerAdded");
        this.masterizerId = masterizerId;
        this.equalizer = equalizer;
        this.compressor = compressor;
    }
}
