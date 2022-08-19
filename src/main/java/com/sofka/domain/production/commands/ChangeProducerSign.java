package com.sofka.domain.production.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.domain.production.values.ProducerId;
import com.sofka.domain.production.values.ProductionId;
import com.sofka.domain.production.values.Sign;

public class ChangeProducerSign extends Command {
    private final ProductionId productionId;
    private final ProducerId producerId;
    private final Sign sign;


    public ChangeProducerSign(ProductionId productionId, ProducerId producerId, Sign sign) {
        this.productionId = productionId;
        this.producerId = producerId;
        this.sign = sign;
    }

    public ProductionId getProductionId() {
        return productionId;
    }

    public ProducerId getProducerId() {
        return producerId;
    }

    public Sign getSign() {
        return sign;
    }
}
