package com.sofka.domain.song.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.domain.song.values.ReleaseDate;
import com.sofka.domain.song.values.Title;

public class SongCreated extends DomainEvent {
    private final Title title;
    private final ReleaseDate releaseDate;

    public SongCreated(Title title, ReleaseDate releaseDate) {
        super("com.sofka.dddchallenge.SongCreated");
        this.title = title;
        this.releaseDate = releaseDate;
    }

    public Title getTitle() {
        return title;
    }

    public ReleaseDate getReleaseDate() {
        return releaseDate;
    }
}
