package com.sofka.domain.production.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.domain.production.values.IsFinished;

public class ProductionFinished extends DomainEvent {
    private final IsFinished isFinished;

    public ProductionFinished(IsFinished isFinished) {
        super("com.sofka.dddchallenge.Production.ProductionIsFinishedChanged");
        this.isFinished = isFinished;
    }

    public IsFinished getIsFinished() {
        return isFinished;
    }
}
