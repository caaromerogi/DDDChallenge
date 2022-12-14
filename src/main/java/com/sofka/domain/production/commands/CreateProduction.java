package com.sofka.domain.production.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.domain.production.values.IsFinished;
import com.sofka.domain.production.values.ProductionId;
import com.sofka.domain.song.values.SongId;

public class CreateProduction extends Command {
    private final ProductionId productionId;
    private final SongId songId;
    private final IsFinished isFinished;

    public CreateProduction(SongId songId, IsFinished isFinished) {
        this.productionId = new ProductionId();
        this.songId = songId;
        this.isFinished = isFinished;
    }

    public SongId getSongId() {
        return songId;
    }

    public ProductionId getProductionId(){return productionId;}

    public IsFinished getIsFinished() {
        return isFinished;
    }
}
