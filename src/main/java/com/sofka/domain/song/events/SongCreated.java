package com.sofka.domain.song.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.domain.song.values.IsRecorded;
import com.sofka.domain.song.values.ReleaseDate;
import com.sofka.domain.song.values.Title;

public class SongCreated extends DomainEvent {
    private final Title title;
    private final ReleaseDate releaseDate;
    private final IsRecorded isRecorded;

    public SongCreated(Title title, ReleaseDate releaseDate, IsRecorded isRecorded) {
        super("com.sofka.dddchallenge.Song.SongCreated");
        this.title = title;
        this.releaseDate = releaseDate;
        this.isRecorded = isRecorded;
    }

    public Title getTitle() {
        return title;
    }

    public ReleaseDate getReleaseDate() {
        return releaseDate;
    }

    public IsRecorded getIsRecorded() {
        return isRecorded;
    }
}
