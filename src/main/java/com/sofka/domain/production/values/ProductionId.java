package com.sofka.domain.production.values;

import co.com.sofka.domain.generic.Identity;

public class ProductionId extends Identity {
    public ProductionId(){

    }

    private ProductionId(String id){
        super(id);
    }

    public static ProductionId of(String id){
        return new ProductionId(id);
    }
}
