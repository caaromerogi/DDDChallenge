package com.sofka.domain.song;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.domain.generics.Name;
import com.sofka.domain.song.events.*;
import com.sofka.domain.song.values.*;

import java.util.List;
import java.util.Objects;

public class Song extends AggregateEvent<SongId> {
    protected ReleaseDate releaseDate;
    protected Title title;
    protected Singer singer;
    protected Instrumental instrumental;
    protected Lyrics lyrics;

    protected IsRecorded isRecorded;

    public Song(SongId entityId, ReleaseDate releaseDate, Title title, IsRecorded isRecorded) {
        super(entityId);
        appendChange(new SongCreated(title, releaseDate, isRecorded)).apply();
    }

    private Song(SongId songId) {
        super(songId);
        subscribe(new SongChange(this));
    }

    public static Song from(SongId songId, List<DomainEvent> events) {
        var song = new Song(songId);
        events.forEach(song::applyEvent);
        return song;
    }


    public void changeTitle(Title title) {
        Objects.requireNonNull(title);
        appendChange(new TitleChanged(title)).apply();
    }

    public void changeReleaseDate(ReleaseDate releaseDate) {
        Objects.requireNonNull(releaseDate);
        appendChange(new ReleaseDateChanged(releaseDate)).apply();
    }

    public void addSinger(SingerId singerId, Name name, VocalRegister vocalRegister, IsRecorded isRecorded) {
        Objects.requireNonNull(singerId);
        Objects.requireNonNull(name);
        Objects.requireNonNull(vocalRegister);
        Objects.requireNonNull(isRecorded);
        appendChange(new SingerAdded(singerId, name, vocalRegister, isRecorded));
    }

    public void addInstrumental(InstrumentalId instrumentalId, PercussionInstrument percussionInstrument,
                                MelodicInstrument melodicInstrument, IsRecorded isRecorded) {
        Objects.requireNonNull(instrumentalId);
        Objects.requireNonNull(percussionInstrument);
        Objects.requireNonNull(melodicInstrument);
        Objects.requireNonNull(isRecorded);
        appendChange(new InstrumentalAdded(instrumentalId, percussionInstrument, melodicInstrument, isRecorded)).apply();
    }

    public void addLyrics(LyricsId lyricsId, Chorus chorus, Verse verse) {
        Objects.requireNonNull(lyricsId);
        Objects.requireNonNull(chorus);
        Objects.requireNonNull(verse);
        appendChange(new LyricsAdded(lyricsId, chorus, verse)).apply();
    }

    public void updateSingerName(SingerId singerId, Name name) {
        Objects.requireNonNull(singerId);
        Objects.requireNonNull(name);
        appendChange(new SingerNameUpdated(singerId, name)).apply();
    }

    public void updateVocalRegister(SingerId singerId, VocalRegister vocalRegister) {
        Objects.requireNonNull(singerId);
        Objects.requireNonNull(vocalRegister);
        appendChange(new VocalRegisterUpdated(singerId, vocalRegister)).apply();
    }

    public void changePercussionInstrument(InstrumentalId instrumentalId, PercussionInstrument percussionInstrument) {
        Objects.requireNonNull(instrumentalId);
        Objects.requireNonNull(percussionInstrument);
        appendChange(new PercussionInstrumentChanged(instrumentalId, percussionInstrument)).apply();
    }

    public void changeMelodicInstrument(InstrumentalId instrumentalId, MelodicInstrument melodicInstrument) {
        Objects.requireNonNull(instrumentalId);
        Objects.requireNonNull(melodicInstrument);
        appendChange(new MelodicInstrumentChanged(instrumentalId, melodicInstrument)).apply();
    }

    public void updateLyricsChorus(LyricsId lyricsId, Chorus chorus) {
        Objects.requireNonNull(lyricsId);
        Objects.requireNonNull(chorus);
        appendChange(new LyricsChorusUpdated(lyricsId, chorus)).apply();
    }

    public void updateLyricsVerse(LyricsId lyricsId, Verse verse) {
        Objects.requireNonNull(lyricsId);
        Objects.requireNonNull(verse);
        appendChange(new LyricsVerseUpdated(lyricsId, verse)).apply();
    }

    public void recordInstrumental(InstrumentalId instrumentalId, IsRecorded isRecorded){
        Objects.requireNonNull(instrumentalId);
        Objects.requireNonNull(isRecorded);
        appendChange((new InstrumentalRecorded(instrumentalId, isRecorded)));
    }
    public void recordSinger(SingerId singerId, IsRecorded isRecorded){
        Objects.requireNonNull(singerId);
        Objects.requireNonNull(isRecorded);
        appendChange(new SingerRecorded(singerId, isRecorded));
    }

    public void changeIsRecorded(IsRecorded isRecorded){
        Objects.requireNonNull(isRecorded);
        appendChange(new SongRecorded(isRecorded));
    }



    public ReleaseDate releaseDate() {
        return releaseDate;
    }

    public Title title() {
        return title;
    }

    public Singer singer() {
        return singer;
    }

    public Instrumental instrumental() {
        return instrumental;
    }

    public Lyrics lyrics() {
        return lyrics;
    }
    public IsRecorded isRecorded(){
        return isRecorded;
    }
}
