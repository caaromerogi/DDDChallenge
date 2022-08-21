package com.sofka.domain.production;

import co.com.sofka.domain.generic.EventChange;
import com.sofka.domain.production.events.*;


public class ProductionChange extends EventChange {
    public ProductionChange(Production production) {
        apply((ProductionCreated event) -> {
            production.songId = event.getSongId();
        });

        apply((ProducerAdded event) -> production.producer = new Producer(event.getProducerId(), event.getName(), event.getSign()));

        apply((RecorderAdded event) -> production.recorder = new Recorder(event.getRecorderId(), event.getVolume(), event.getBrand()));

        apply((MasterizerAdded event) -> production.masterizer = new Masterizer(event.getMasterizerId(), event.getEqualizer(), event.getCompressor()));

        apply((ProductionFinished event) -> production.isFinished = event.getIsFinished());

        apply((RecorderVolumeAdjusted event) -> production.adjustRecorderVolume(event.getRecorderId(), event.getVolume()));

        apply((RecorderBrandChanged event) -> production.changeRecorderBrand(event.getRecorderId(), event.getBrand()));

        apply((CompressorChanged event) -> production.changeCompressor(event.getMasterizerId(), event.getCompressor()));

        apply((EqualizerChanged event) -> production.changeEqualizer(event.getMasterizerId(), event.getEqualizer()));

        apply((ProducerSignChanged event) -> production.changeProducerSign(event.getProducerId(), event.getSign()));

        apply((ProducerNameUpdated event) -> production.updateProducerName(event.getProducerId(), event.getName()));

    }

}
