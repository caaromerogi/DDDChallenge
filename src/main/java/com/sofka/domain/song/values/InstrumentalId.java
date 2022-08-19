package com.sofka.domain.song.values;

import co.com.sofka.domain.generic.Identity;

public class InstrumentalId extends Identity {
    public InstrumentalId(){

    }

    private InstrumentalId(String id){
        super(id);
    }

    public static InstrumentalId of(String id){
        return new InstrumentalId(id);
    }
}
