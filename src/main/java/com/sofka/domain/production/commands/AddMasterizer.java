package com.sofka.domain.production.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.domain.production.values.Compressor;
import com.sofka.domain.production.values.Equalizer;
import com.sofka.domain.production.values.MasterizerId;
import com.sofka.domain.production.values.ProductionId;

public class AddMasterizer extends Command {
    private final ProductionId productionId;
    private final MasterizerId masterizerId;
    private final Equalizer equalizer;
    private final Compressor compressor;


    public AddMasterizer(ProductionId productionId, MasterizerId masterizerId, Equalizer equalizer, Compressor compressor) {
        this.productionId = productionId;
        this.masterizerId = masterizerId;
        this.equalizer = equalizer;
        this.compressor = compressor;
    }

    public ProductionId getProductionId() {
        return productionId;
    }

    public MasterizerId getMasterizerId() {
        return masterizerId;
    }

    public Equalizer getEqualizer() {
        return equalizer;
    }

    public Compressor getCompressor() {
        return compressor;
    }
}
