package com.sofka.domain.production;

import co.com.sofka.domain.generic.AggregateEvent;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.domain.generics.Name;
import com.sofka.domain.production.events.*;
import com.sofka.domain.production.values.*;
import com.sofka.domain.song.values.SongId;


import java.util.List;
import java.util.Objects;

public class Production extends AggregateEvent<ProductionId> {

    protected SongId songId;
    protected Masterizer masterizer;
    protected Recorder recorder;
    protected Producer producer;

    public Production(ProductionId entityId, SongId songId) {
        super(entityId);
        //Agregar más value objects
        appendChange(new ProductionCreated(songId)).apply();
    }

    private Production(ProductionId productionId) {
        super(productionId);
        subscribe(new ProductionChange(this));
    }

    public static Production from(ProductionId productionId, List<DomainEvent> events) {
        var production = new Production(productionId);
        events.forEach(production::applyEvent);
        return production;
    }

    public void addProducer(ProducerId producerId, Name name, Sign sign){
        Objects.requireNonNull(producerId);
        Objects.requireNonNull(name);
        Objects.requireNonNull(sign);
        appendChange(new ProducerAdded(producerId, name, sign));
    }

    public void addRecorder(RecorderId recorderId, Volume volume, Brand brand){
        Objects.requireNonNull(recorderId);
        Objects.requireNonNull(volume);
        Objects.requireNonNull(brand);
        appendChange(new RecorderAdded(recorderId, volume, brand));
    }

    public void addMasterizer(MasterizerId masterizerId, Equalizer equalizer, Compressor compressor){
        Objects.requireNonNull(masterizerId);
        Objects.requireNonNull(equalizer);
        Objects.requireNonNull(compressor);
        appendChange(new MasterizerAdded(masterizerId, equalizer, compressor));
    }

    public void updateProducerName(ProducerId producerId, Name name){
        Objects.requireNonNull(producerId);
        Objects.requireNonNull(name);
        appendChange(new ProducerNameUpdated(producerId, name));
    }

    public void changeProducerSign(ProducerId producerId, Sign sign){
        Objects.requireNonNull(producerId);
        Objects.requireNonNull(sign);
        appendChange(new ProducerSignChanged(producerId,sign));
    }

    public void adjustRecorderVolume(RecorderId recorderId, Volume volume){
        Objects.requireNonNull(recorderId);
        Objects.requireNonNull(volume);
        appendChange(new RecorderVolumeAdjusted(recorderId, volume));
    }

    public void changeRecorderBrand(RecorderId recorderId, Brand brand){
        Objects.requireNonNull(recorderId);
        Objects.requireNonNull(brand);
        appendChange(new RecorderBrandChanged(recorderId, brand));
    }

    public void changeEqualizer(MasterizerId masterizerId, Equalizer equalizer){
        Objects.requireNonNull(masterizerId);
        Objects.requireNonNull(equalizer);
        appendChange(new EqualizerChanged(masterizerId, equalizer));
    }

    public void changeCompressor(MasterizerId masterizerId, Compressor compressor){
        Objects.requireNonNull(masterizerId);
        Objects.requireNonNull(compressor);
        appendChange(new CompressorChanged(masterizerId, compressor));
    }

    public SongId songId() {
        return songId;
    }

    public Masterizer masterizer() {
        return masterizer;
    }

    public Recorder recorder() {
        return recorder;
    }

    public Producer producer() {
        return producer;
    }
}
