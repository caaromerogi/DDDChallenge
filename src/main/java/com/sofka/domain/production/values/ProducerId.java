package com.sofka.domain.production.values;

import co.com.sofka.domain.generic.Identity;

public class ProducerId extends Identity {
    public ProducerId() {

    }

    private ProducerId(String id){
        super(id);
    }

    public static ProducerId of(String id){
        return new ProducerId(id);
    }
}
