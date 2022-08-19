package com.sofka.domain.production.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.domain.generics.Name;
import com.sofka.domain.production.values.ProducerId;
import com.sofka.domain.production.values.ProductionId;

public class UpdateProducerName extends Command {
    private final ProductionId productionId;
    private final ProducerId producerId;
    private final Name name;


    public UpdateProducerName(ProductionId productionId, ProducerId producerId, Name name) {
        this.productionId = productionId;
        this.producerId = producerId;
        this.name = name;
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
}
