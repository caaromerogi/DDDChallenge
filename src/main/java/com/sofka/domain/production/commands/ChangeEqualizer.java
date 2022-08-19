package com.sofka.domain.production.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.domain.production.values.Equalizer;
import com.sofka.domain.production.values.MasterizerId;
import com.sofka.domain.production.values.ProductionId;

public class ChangeEqualizer extends Command {
    private final ProductionId productionId;
    private final MasterizerId masterizerId;
    private final Equalizer equalizer;


    public ChangeEqualizer(ProductionId productionId, MasterizerId masterizerId, Equalizer equalizer) {
        this.productionId = productionId;
        this.masterizerId = masterizerId;
        this.equalizer = equalizer;
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
}
