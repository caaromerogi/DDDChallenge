package com.sofka.domain.song;

import co.com.sofka.domain.generic.Entity;
import com.sofka.domain.song.values.Chorus;
import com.sofka.domain.song.values.LyricsId;
import com.sofka.domain.song.values.Verse;

import java.util.Objects;

public class Lyrics extends Entity<LyricsId> {
    private Chorus chorus;
    private Verse verse;

    public Lyrics(LyricsId entityId) {
        super(entityId);
    }

    public void updateChorus(Chorus chorus){
        this.chorus = Objects.requireNonNull(chorus);
    }

    public void updateVerse(Verse verse) {
        this.verse = Objects.requireNonNull(verse);
    }

    public Chorus chorus() {
        return chorus;
    }

    public Verse verse() {
        return verse;
    }
}
