package com.sofka.domain.song;

import co.com.sofka.domain.generic.EventChange;
import com.sofka.domain.song.events.SongCreated;

public class SongChange extends EventChange {
    public SongChange(Song song){
        apply((SongCreated event) ->{
            song.releaseDate = event.getReleaseDate();
            song.title = event.getTitle();

        });
    }
}
