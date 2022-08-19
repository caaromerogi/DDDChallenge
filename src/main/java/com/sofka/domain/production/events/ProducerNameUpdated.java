package com.sofka.domain.production.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.domain.generics.Name;
import com.sofka.domain.production.values.ProducerId;

public class ProducerNameUpdated extends DomainEvent {
    private final ProducerId producerId;
    private final Name name;


    public ProducerNameUpdated(ProducerId producerId, Name name) {
        super("com.sofka.dddchallenge.Production.ProducerNameUpdated");
        this.producerId = producerId;
        this.name = name;
    }

    public ProducerId getProducerId() {
        return producerId;
    }

    public Name getName() {
        return name;
    }
}
