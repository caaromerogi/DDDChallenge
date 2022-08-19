package com.sofka.domain.song.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.domain.song.values.LyricsId;
import com.sofka.domain.song.values.Verse;

public class LyricsVerseUpdated extends DomainEvent {
    private final LyricsId lyricsId;
    private final Verse verse;


    public LyricsVerseUpdated(LyricsId lyricsId, Verse verse) {
        super("com.sofka.dddchallenge.Song.LyricsVerseUpdated");
        this.lyricsId = lyricsId;
        this.verse = verse;
    }

    public LyricsId getLyricsId() {
        return lyricsId;
    }

    public Verse getVerse() {
        return verse;
    }
}
