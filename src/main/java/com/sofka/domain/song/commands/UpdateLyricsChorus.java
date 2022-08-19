package com.sofka.domain.song.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.domain.song.values.Chorus;
import com.sofka.domain.song.values.LyricsId;
import com.sofka.domain.song.values.SongId;

public class UpdateLyricsChorus extends Command {
    private final SongId songId;
    private final LyricsId lyricsId;
    private final Chorus chorus;


    public UpdateLyricsChorus(SongId songId, LyricsId lyricsId, Chorus chorus) {
        this.songId = songId;
        this.lyricsId = lyricsId;
        this.chorus = chorus;
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
}
