package com.sofka.domain.song.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.domain.generics.Name;
import com.sofka.domain.song.values.IsRecorded;
import com.sofka.domain.song.values.SingerId;
import com.sofka.domain.song.values.VocalRegister;

public class SingerAdded extends DomainEvent {
    private final SingerId singerId;
    private final Name name;
    private final VocalRegister vocalRegister;

    private final IsRecorded isRecorded;


    public SingerAdded(SingerId singerId, Name name, VocalRegister vocalRegister, IsRecorded isRecorded) {
        super("com.sofka.dddchallenge.Song.SingerAdded");
        this.singerId = singerId;
        this.name = name;
        this.vocalRegister = vocalRegister;
        this.isRecorded = isRecorded;
    }

    public SingerId getSingerId() {
        return singerId;
    }

    public Name getName() {
        return name;
    }

    public VocalRegister getVocalRegister() {
        return vocalRegister;
    }

    public IsRecorded getIsRecorded() {
        return isRecorded;
    }
}
