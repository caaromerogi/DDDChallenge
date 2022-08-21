package com.sofka.domain.production.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.domain.production.values.Brand;
import com.sofka.domain.production.values.ProductionId;
import com.sofka.domain.production.values.RecorderId;

public class ChangeRecorderBrand extends Command {
    private final ProductionId productionId;
    private final RecorderId RecorderId;
    private final Brand brand;


    public ChangeRecorderBrand(ProductionId productionId, com.sofka.domain.production.values.RecorderId recorderId, Brand brand) {
        this.productionId = productionId;
        this.RecorderId = recorderId;
        this.brand = brand;
    }

    public ProductionId getProductionId() {
        return productionId;
    }

    public com.sofka.domain.production.values.RecorderId getRecorderId() {
        return RecorderId;
    }

    public Brand getBrand() {
        return brand;
    }
}
