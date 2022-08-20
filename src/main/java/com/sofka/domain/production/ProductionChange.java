package com.sofka.domain.production;

import co.com.sofka.domain.generic.EventChange;
import com.sofka.domain.production.events.MasterizerAdded;
import com.sofka.domain.production.events.ProducerAdded;
import com.sofka.domain.production.events.ProductionCreated;
import com.sofka.domain.production.events.RecorderAdded;


public class ProductionChange extends EventChange {
    public ProductionChange(Production production){
        apply((ProductionCreated event) ->{
            production.songId = event.getSongId();
        });

        apply((ProducerAdded event) -> production.producer = new Producer(event.getProducerId(), event.getName(),event.getSign()));

        apply((RecorderAdded event) -> production.recorder = new Recorder(event.getRecorderId(), event.getVolume(), event.getBrand()));

        apply((MasterizerAdded event) -> production.masterizer = new Masterizer(event.getMasterizerId(), event.getEqualizer(), event.getCompressor()) );
    }

}
