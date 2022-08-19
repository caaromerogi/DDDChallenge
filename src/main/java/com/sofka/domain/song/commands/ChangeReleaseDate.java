package com.sofka.domain.song.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.domain.song.values.ReleaseDate;
import com.sofka.domain.song.values.SongId;

public class ChangeReleaseDate extends Command {
    private final SongId songID;
    private final ReleaseDate releaseDate;


    public ChangeReleaseDate(SongId songID, ReleaseDate releaseDate) {
        this.songID = songID;
        this.releaseDate = releaseDate;
    }

    public SongId getSongID() {
        return songID;
    }

    public ReleaseDate getReleaseDate() {
        return releaseDate;
    }
}
