package com.sofka.domain.song.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.domain.song.values.ReleaseDate;

public class ReleaseDateChanged extends DomainEvent {
    private final ReleaseDate releaseDate;


    public ReleaseDateChanged(ReleaseDate releaseDate) {
        super("com.sofka.dddchallenge.Song.ReleaseDateChanged");
        this.releaseDate = releaseDate;
    }

    public ReleaseDate getReleaseDate() {
        return releaseDate;
    }
}
