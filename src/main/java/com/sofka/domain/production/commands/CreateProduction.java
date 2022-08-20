package com.sofka.domain.production.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.domain.production.values.ProductionId;
import com.sofka.domain.song.values.SongId;

public class CreateProduction extends Command {
    private final ProductionId productionId;
    private final SongId songId;

    public CreateProduction(SongId songId) {
        this.productionId = new ProductionId();
        this.songId = songId;
    }

    public SongId getSongId() {
        return songId;
    }
}
