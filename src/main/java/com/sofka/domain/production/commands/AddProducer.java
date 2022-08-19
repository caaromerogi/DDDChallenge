package com.sofka.domain.production.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.domain.generics.Name;
import com.sofka.domain.production.values.ProducerId;
import com.sofka.domain.production.values.ProductionId;
import com.sofka.domain.production.values.Sign;

public class AddProducer extends Command {
    private final ProductionId productionId;
    private final ProducerId producerId;
    private final Name name;
    private final Sign sign;


    public AddProducer(ProductionId productionId, ProducerId producerId, Name name, Sign sign) {
        this.productionId = productionId;
        this.producerId = producerId;
        this.name = name;
        this.sign = sign;
    }

    public ProductionId getProductionId() {
        return productionId;
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
