package com.sofka.domain.production.values;

import co.com.sofka.domain.generic.Identity;

public class RecorderId extends Identity {
    public RecorderId() {

    }

    private RecorderId(String id){
        super(id);
    }

    public static RecorderId of(String id){
        return new RecorderId(id);
    }
}
