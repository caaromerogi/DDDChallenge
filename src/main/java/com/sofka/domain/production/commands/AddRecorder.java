package com.sofka.domain.production.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.domain.production.values.ProductionId;
import com.sofka.domain.production.values.RecorderId;
import com.sofka.domain.production.values.Volume;

public class AddRecorder extends Command {
    private final ProductionId productionId;
    private final RecorderId recorderId;
    private final Volume volume;


    public AddRecorder(ProductionId productionId, RecorderId recorderId, Volume volume) {
        this.productionId = productionId;
        this.recorderId = recorderId;
        this.volume = volume;
    }

    public ProductionId getProductionId() {
        return productionId;
    }

    public RecorderId getRecorderId() {
        return recorderId;
    }

    public Volume getVolume() {
        return volume;
    }
}
