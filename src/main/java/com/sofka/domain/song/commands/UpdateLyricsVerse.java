package com.sofka.domain.song.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.domain.song.values.LyricsId;
import com.sofka.domain.song.values.SongId;
import com.sofka.domain.song.values.Verse;

public class UpdateLyricsVerse extends Command {
    private final SongId songId;
    private final LyricsId lyricsId;
    private final Verse verse;

    public UpdateLyricsVerse(SongId songId, LyricsId lyricsId, Verse verse) {
        this.songId = songId;
        this.lyricsId = lyricsId;
        this.verse = verse;
    }

    public SongId getSongId() {
        return songId;
    }

    public LyricsId getLyricsId() {
        return lyricsId;
    }

    public Verse getVerse() {
        return verse;
    }
}
