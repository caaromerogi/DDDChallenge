package com.sofka.domain.production.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.domain.song.values.SongId;

public class ProductionCreated extends DomainEvent {
    private final SongId songId;


    public ProductionCreated(SongId songId) {
        super("com.sofka.dddchallenge.Production.ProductionCreated");
        this.songId = songId;
    }

    public SongId getSongId() {
        return songId;
    }
}
