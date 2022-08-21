package com.sofka.domain.song;

import co.com.sofka.domain.generic.EventChange;
import com.sofka.domain.song.events.InstrumentalAdded;
import com.sofka.domain.song.events.LyricsAdded;
import com.sofka.domain.song.events.SingerAdded;
import com.sofka.domain.song.events.SongCreated;

public class SongChange extends EventChange {
    public SongChange(Song song){
        apply((SongCreated event) ->{
            song.releaseDate = event.getReleaseDate();
            song.title = event.getTitle();
        });

        apply((SingerAdded event) -> song.singer = new Singer(event.getSingerId(), event.getName(),event.getVocalRegister(), event.getIsRecorded()));

        apply((InstrumentalAdded event) -> song.instrumental = new Instrumental(event.getInstrumentalId(), event.getPercussionInstrument(), event.getMelodicInstrumental(), event.getIsRecorded()));

        apply((LyricsAdded event) -> song.lyrics = new Lyrics(event.getLyricsId(), event.getChorus(), event.getVerse()));





    }


}

