package com.sofka.domain.song;

import co.com.sofka.domain.generic.Entity;
import com.sofka.domain.generics.Name;
import com.sofka.domain.song.values.IsRecorded;
import com.sofka.domain.song.values.SingerId;
import com.sofka.domain.song.values.VocalRegister;

import java.util.Objects;

public class Singer extends Entity<SingerId> {
    private Name name;
    private VocalRegister vocalRegister;

    private IsRecorded isRecorded;


    public Singer(SingerId entityId, Name name, VocalRegister vocalRegister, IsRecorded isRecorded) {
        super(entityId);
        this.name = name;
        this.vocalRegister = vocalRegister;
        this.isRecorded = isRecorded;
    }

    public void updateName(Name name){
        this.name = Objects.requireNonNull(name);
    }

    public void updateVocalRegister(VocalRegister vocalRegister){
        this.vocalRegister = Objects.requireNonNull(vocalRegister);
    }

    public void recordSinger(IsRecorded isRecorded){
        this.isRecorded = Objects.requireNonNull(isRecorded);
    }

    public Name name() {
        return name;
    }

    public VocalRegister vocalRegister() {
        return vocalRegister;
    }

    public IsRecorded isRecorded() {
        return isRecorded;
    }
}
