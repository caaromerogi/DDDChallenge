package com.sofka.domain.production.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.domain.production.values.Compressor;
import com.sofka.domain.production.values.MasterizerId;

public class CompressorChanged extends DomainEvent {
    private final MasterizerId masterizerId;
    private final Compressor compressor;


    public CompressorChanged(MasterizerId masterizerId, Compressor compressor) {
        super("com.sofka.dddchallenge.Production.CompressorChanged");
        this.masterizerId = masterizerId;
        this.compressor = compressor;
    }
}
