package com.sofka.domain.production.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.domain.production.values.Compressor;
import com.sofka.domain.production.values.MasterizerId;
import com.sofka.domain.production.values.ProductionId;

public class ChangeCompressor extends Command {
    private final ProductionId productionId;
    private final MasterizerId masterizerId;
    private final Compressor compressor;


    public ChangeCompressor(ProductionId productionId, MasterizerId masterizerId, Compressor compressor) {
        this.productionId = productionId;
        this.masterizerId = masterizerId;
        this.compressor = compressor;
    }

    public ProductionId getProductionId() {
        return productionId;
    }

    public MasterizerId getMasterizerId() {
        return masterizerId;
    }

    public Compressor getCompressor() {
        return compressor;
    }
}
