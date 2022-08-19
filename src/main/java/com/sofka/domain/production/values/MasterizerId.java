package com.sofka.domain.production.values;

import co.com.sofka.domain.generic.Identity;

public class MasterizerId extends Identity {
    public MasterizerId(){

    }

    private MasterizerId(String id){
        super(id);
    }

    public static MasterizerId of(String id){
        return new MasterizerId(id);
    }
}
