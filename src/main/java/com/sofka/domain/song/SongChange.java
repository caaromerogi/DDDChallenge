package com.sofka.domain.song;

import co.com.sofka.domain.generic.EventChange;
import com.sofka.domain.song.events.*;
import com.sofka.domain.song.values.ReleaseDate;

public class SongChange extends EventChange {
    public SongChange(Song song) {
        apply((SongCreated event) -> {
            song.releaseDate = event.getReleaseDate();
            song.title = event.getTitle();
        });

        apply((SingerAdded event) -> song.singer = new Singer(event.getSingerId(), event.getName(), event.getVocalRegister(), event.getIsRecorded()));

        apply((InstrumentalAdded event) -> song.instrumental = new Instrumental(event.getInstrumentalId(), event.getPercussionInstrument(), event.getMelodicInstrumental(), event.getIsRecorded()));

        apply((LyricsAdded event) -> song.lyrics = new Lyrics(event.getLyricsId(), event.getChorus(), event.getVerse()));

        apply((SongRecorded event) -> song.changeIsRecorded(event.getIsRecorded()));

        apply((TitleChanged event) -> song.changeTitle(event.getTitle()));

        apply((ReleaseDateChanged event) -> song.changeReleaseDate(event.getReleaseDate()));

        apply((InstrumentalRecorded event) -> song.instrumental.recordInstrumental(event.getIsRecorded()));

        apply((PercussionInstrumentChanged event) -> song.instrumental.changePercussionInstrument(event.getPercussionInstrument()));

        apply((MelodicInstrumentChanged event) ->song.instrumental.changeMelodicInstrument(event.getMelodicInstrument()) );

        apply((SingerRecorded event) -> song.singer.recordSinger(event.getIsRecorded()));

        apply((SingerNameUpdated event) -> song.singer.updateName(event.getName()));

        apply((VocalRegisterUpdated event) -> song.singer.updateVocalRegister(event.getVocalRegister()));

        apply((LyricsChorusUpdated event) -> song.lyrics.updateChorus(event.getChorus()));

        apply((LyricsVerseUpdated event) ->song.lyrics.updateVerse(event.getVerse()));
    }


}

