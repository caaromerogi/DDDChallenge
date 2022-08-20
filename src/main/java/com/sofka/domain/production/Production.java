package com.sofka.domain.production;

import co.com.sofka.domain.generic.AggregateEvent;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.domain.production.events.ProductionCreated;
import com.sofka.domain.production.values.ProductionId;
import com.sofka.domain.song.values.SongId;


import java.util.List;

public class Production extends AggregateEvent<ProductionId> {

    protected SongId songId;
    protected Masterizer masterizer;
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
}
