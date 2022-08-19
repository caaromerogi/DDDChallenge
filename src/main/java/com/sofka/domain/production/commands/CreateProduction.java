package com.sofka.domain.production.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.domain.production.values.ProductionId;
import com.sofka.domain.song.values.SongId;

public class CreateProduction extends Command {
    private final ProductionId productionId;

    private final SongId songId;

    public CreateProduction(ProductionId productionId, SongId songId) {
        this.productionId = productionId;
        this.songId = songId;
    }

    public ProductionId getProductionId() {
        return productionId;
    }

    public SongId getSongId() {
        return songId;
    }
}
