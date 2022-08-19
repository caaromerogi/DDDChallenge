package com.sofka.domain.song.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.domain.song.values.Chorus;
import com.sofka.domain.song.values.LyricsId;

public class LyricsChorusUpdated extends DomainEvent {
    private final LyricsId lyricsId;
    private final Chorus chorus;


    public LyricsChorusUpdated(LyricsId lyricsId, Chorus chorus) {
        super("com.sofka.dddchallenge.Song.LyricsChorusUpdated");
        this.lyricsId = lyricsId;
        this.chorus = chorus;
    }

    public LyricsId getLyricsId() {
        return lyricsId;
    }

    public Chorus getChorus() {
        return chorus;
    }
}
