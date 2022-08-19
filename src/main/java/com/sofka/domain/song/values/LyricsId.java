package com.sofka.domain.song.values;

import co.com.sofka.domain.generic.Identity;

public class LyricsId extends Identity {
    public LyricsId() {

    }

    private LyricsId(String id){
        super(id);
    }

    public static LyricsId of(String id){
        return new LyricsId(id);
    }
}
