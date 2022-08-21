package com.sofka.domain.production.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.domain.production.values.IsFinished;
import com.sofka.domain.production.values.ProductionId;

public class FinishProduction extends Command {
    private final ProductionId productionId;
    private final IsFinished isFinished;

    public FinishProduction(ProductionId productionId, IsFinished isFinished) {
        this.productionId = productionId;
        this.isFinished = isFinished;
    }

    public ProductionId getProductionId() {
        return productionId;
    }

    public IsFinished getIsFinished() {
        return isFinished;
    }
}
