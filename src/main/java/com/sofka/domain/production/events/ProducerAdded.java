package com.sofka.domain.production.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.domain.generics.Name;
import com.sofka.domain.production.values.ProducerId;
import com.sofka.domain.production.values.Sign;

public class ProducerAdded extends DomainEvent {
    private final ProducerId producerId;
    private final Name name;
    private final Sign sign;


    public ProducerAdded(ProducerId producerId, Name name, Sign sign) {
        super("com.sofka.dddchallenge.Production.ProducerAdded");
        this.producerId = producerId;
        this.name = name;
        this.sign = sign;
    }

    public ProducerId getProducerId() {
        return producerId;
    }

    public Name getName() {
        return name;
    }

    public Sign getSign() {
        return sign;
    }
}
