package com.sofka.domain.production.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.domain.production.values.IsFinished;
import com.sofka.domain.song.values.SongId;

public class ProductionCreated extends DomainEvent {
    private final SongId songId;

    private final IsFinished isFinished;


    public ProductionCreated(SongId songId, IsFinished isFinished) {
        super("com.sofka.dddchallenge.Production.ProductionCreated");
        this.songId = songId;
        this.isFinished = isFinished;
    }

    public SongId getSongId() {
        return songId;
    }

    public IsFinished getIsFinished() {
        return isFinished;
    }
}
