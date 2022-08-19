package com.sofka.domain.song.values;

import co.com.sofka.domain.generic.Identity;

public class SingerId extends Identity {
    public SingerId() {
    }

    private SingerId (String id){
        super(id);
    }

    public static SingerId of(String id){
        return new SingerId(id);
    }
}
