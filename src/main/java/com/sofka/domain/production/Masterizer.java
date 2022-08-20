package com.sofka.domain.production;

import co.com.sofka.domain.generic.Entity;
import com.sofka.domain.generics.Name;
import com.sofka.domain.production.values.*;

import java.util.Objects;

public class Masterizer extends Entity<MasterizerId> {
    private Equalizer equalizer;
    private Compressor compressor;


    public Masterizer(MasterizerId entityId, Equalizer equalizer, Compressor compressor) {
        super(entityId);
        this.equalizer = equalizer;
        this.compressor = compressor;
    }

    public void changeEqualizer(Equalizer equalizer){
        this.equalizer = Objects.requireNonNull(equalizer);
    }

    public void changeCompressor(Compressor compressor){
        this.compressor = Objects.requireNonNull(compressor);
    }

    public Equalizer equalizer() {
        return equalizer;
    }

    public Compressor compressor() {
        return compressor;
    }
}
