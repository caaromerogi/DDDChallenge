package com.sofka.domain.song.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.domain.song.values.Chorus;
import com.sofka.domain.song.values.LyricsId;
import com.sofka.domain.song.values.Verse;

public class LyricsAdded extends DomainEvent {
    private final LyricsId lyricsId;
    private final Chorus chorus;
    private final Verse verse;

    public LyricsAdded(LyricsId lyricsId, Chorus chorus, Verse verse) {
        super("com.sofka.dddchallenge.Song.LyricsAdded");
        this.lyricsId = lyricsId;
        this.chorus = chorus;
        this.verse = verse;
    }

    public LyricsId getLyricsId() {
        return lyricsId;
    }

    public Chorus getChorus() {
        return chorus;
    }

    public Verse getVerse() {
        return verse;
    }
}
