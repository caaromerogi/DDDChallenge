package com.sofka.domain.song.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.domain.generics.Name;
import com.sofka.domain.song.values.SingerId;

public class SingerNameUpdated extends DomainEvent {
    private final SingerId singerId;
    private final Name name;


    public SingerNameUpdated(SingerId singerId, Name name) {
        super("com.sofka.dddchallenge.Song.SingerNameUpdated");
        this.singerId = singerId;
        this.name = name;
    }

    public SingerId getSingerId() {
        return singerId;
    }

    public Name getName() {
        return name;
    }
}
