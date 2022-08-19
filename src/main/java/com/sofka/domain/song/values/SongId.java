package com.sofka.domain.song.values;

import co.com.sofka.domain.generic.Identity;

public class SongId extends Identity {
    public SongId() {

    }

    private SongId(String id){
        super(id);}

    public static SongId of(String id){
        return new SongId(id);
    }
}
