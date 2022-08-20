package com.sofka.domain.song.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.domain.song.values.ReleaseDate;
import com.sofka.domain.song.values.SongId;
import com.sofka.domain.song.values.Title;

public class CreateSong extends Command {
    private final SongId songId;
    private final Title title;
    private final ReleaseDate releaseDate;

    public CreateSong(Title title, ReleaseDate releaseDate) {
        this.songId = new SongId();
        this.title = title;
        this.releaseDate = releaseDate;
    }

    public SongId getSongId() {
        return songId;
    }

    public Title getTitle() {
        return title;
    }

    public ReleaseDate getReleaseDate() {
        return releaseDate;
    }
}
