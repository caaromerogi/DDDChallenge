package com.sofka.domain.production.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.domain.production.values.ProducerId;
import com.sofka.domain.production.values.Sign;

public class ProducerSignChanged extends DomainEvent {
    private final ProducerId producerId;
    private final Sign sign;


    public ProducerSignChanged(ProducerId producerId, Sign sign) {
        super("com.sofka.dddchallenge.Production.ProducerSignChanged");
        this.producerId = producerId;
        this.sign = sign;
    }

    public ProducerId getProducerId() {
        return producerId;
    }

    public Sign getSign() {
        return sign;
    }
}
