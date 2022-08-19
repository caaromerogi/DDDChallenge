package com.sofka.domain.song.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.domain.song.values.SongId;
import com.sofka.domain.song.values.Title;

public class ChangeTitle extends Command {
    private final SongId songId;
    private final Title title;


    public ChangeTitle(SongId songId, Title title) {
        this.songId = songId;
        this.title = title;
    }

    public SongId getSongId() {
        return songId;
    }

    public Title getTitle() {
        return title;
    }
}
