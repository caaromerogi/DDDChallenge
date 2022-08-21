package com.sofka.domain.song.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.domain.song.values.IsRecorded;

public class SongRecorded extends DomainEvent {
    private final IsRecorded isRecorded;

    public SongRecorded(IsRecorded isRecorded) {
        super("com.sofka.dddchallenge.Song.SongIsRecord");
        this.isRecorded = isRecorded;
    }

    public IsRecorded getIsRecorded() {
        return isRecorded;
    }
}
