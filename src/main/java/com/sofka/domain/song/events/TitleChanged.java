package com.sofka.domain.song.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.domain.song.values.Title;

public class TitleChanged extends DomainEvent {
    private final Title title;

    public TitleChanged(Title title) {
        super("com.sofka.dddchallenge.Song.TitleChanged");
        this.title = title;
    }

    public Title getTitle() {
        return title;
    }
}
