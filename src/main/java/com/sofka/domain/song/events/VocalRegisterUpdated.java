package com.sofka.domain.song.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.domain.song.values.SingerId;
import com.sofka.domain.song.values.VocalRegister;

public class VocalRegisterUpdated extends DomainEvent {
    private final SingerId singerId;
    private final VocalRegister vocalRegister;


    public VocalRegisterUpdated(SingerId singerId, VocalRegister vocalRegister) {
        super("com.sofka.dddchallenge.Song.VocalRegisterUpdated");
        this.singerId = singerId;
        this.vocalRegister = vocalRegister;
    }

    public SingerId getSingerId() {
        return singerId;
    }

    public VocalRegister getVocalRegister() {
        return vocalRegister;
    }
}
