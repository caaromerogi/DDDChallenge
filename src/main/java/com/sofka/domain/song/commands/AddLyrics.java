package com.sofka.domain.song.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.domain.song.values.Chorus;
import com.sofka.domain.song.values.LyricsId;
import com.sofka.domain.song.values.SongId;
import com.sofka.domain.song.values.Verse;

public class AddLyrics extends Command {
    private final SongId songId;
    private final LyricsId lyricsId;
    private final Chorus chorus;
    private final Verse verse;


    public AddLyrics(SongId songId, LyricsId lyricsId, Chorus chorus, Verse verse) {
        this.songId = songId;
        this.lyricsId = lyricsId;
        this.chorus = chorus;
        this.verse = verse;
    }

    public SongId getSongId() {
        return songId;
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
