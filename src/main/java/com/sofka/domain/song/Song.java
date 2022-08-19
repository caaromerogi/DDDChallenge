package com.sofka.domain.song;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.domain.generics.Name;
import com.sofka.domain.song.events.*;
import com.sofka.domain.song.values.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Song extends AggregateEvent<SongId> {
    protected ReleaseDate releaseDate;
    protected Title title;
    protected Set<Singer> singers;
    protected Set<Instrumental> instrumentals;
    protected Set<Lyrics> lyrics;

    public Song(SongId entityId, ReleaseDate releaseDate, Title title) {
        super(entityId);
        appendChange(new SongCreated(title,releaseDate)).apply();
    }

    private Song(SongId songId){
        super(songId);
        subscribe(new SongChange(this));
    }

    public static Song from(SongId songId, List<DomainEvent> events){
        var song = new Song(songId);
        events.forEach(song::applyEvent);
        return song;
    }


    public void changeTitle(Title title){
        Objects.requireNonNull(title);
        appendChange(new TitleChanged(title)).apply();
    }

    public void changeReleaseDate(ReleaseDate releaseDate){
        Objects.requireNonNull(releaseDate);
        appendChange(new ReleaseDateChanged(releaseDate)).apply();
    }

    public void addSinger(SingerId singerId, Name name, VocalRegister vocalRegister){
        Objects.requireNonNull(singerId);
        Objects.requireNonNull(name);
        Objects.requireNonNull(vocalRegister);
        appendChange(new SingerAdded(singerId, name, vocalRegister));
    }

    public void addInstrumental(InstrumentalId instrumentalId, PercussionInstrument percussionInstrument,
                                MelodicInstrument melodicInstrument){
        Objects.requireNonNull(instrumentalId);
        Objects.requireNonNull(percussionInstrument);
        Objects.requireNonNull(melodicInstrument);
        appendChange(new InstrumentalAdded(instrumentalId, percussionInstrument, melodicInstrument)).apply();
    }

    public void addLyrics(LyricsId lyricsId, Chorus chorus, Verse verse){
        Objects.requireNonNull(lyricsId);
        Objects.requireNonNull(chorus);
        Objects.requireNonNull(verse);
        appendChange(new LyricsAdded(lyricsId, chorus, verse)).apply();
    }

    public void updateSingerName(SingerId singerId, Name name){
        Objects.requireNonNull(singerId);
        Objects.requireNonNull(name);
        appendChange(new SingerNameUpdated(singerId, name)).apply();
    }

    public void updateVocalRegister(SingerId singerId, VocalRegister vocalRegister) {
        Objects.requireNonNull(singerId);
        Objects.requireNonNull(vocalRegister);
        appendChange(new VocalRegisterUpdated(singerId, vocalRegister)).apply();
    }

    public void changePercussionInstrument(InstrumentalId instrumentalId, PercussionInstrument percussionInstrument){
        Objects.requireNonNull(instrumentalId);
        Objects.requireNonNull(percussionInstrument);
        appendChange(new PercussionInstrumentChanged(instrumentalId, percussionInstrument)).apply();
    }

    public void changeMelodicInstrument(InstrumentalId instrumentalId, MelodicInstrument melodicInstrument){
        Objects.requireNonNull(instrumentalId);
        Objects.requireNonNull(melodicInstrument);
        appendChange(new MelodicInstrumentChanged(instrumentalId, melodicInstrument)).apply();
    }

    public void updateLyricsChorus(LyricsId lyricsId, Chorus chorus){
        Objects.requireNonNull(lyricsId);
        Objects.requireNonNull(chorus);
        appendChange(new LyricsChorusUpdated(lyricsId, chorus)).apply();
    }

    public void updateLyricsVerse(LyricsId lyricsId, Verse verse){
        Objects.requireNonNull(lyricsId);
        Objects.requireNonNull(verse);
        appendChange(new LyricsVerseUpdated(lyricsId, verse)).apply();
    }

    public Optional<Singer> getSingerById(SingerId singerId){
        return singers().stream().filter((singer -> singer.identity().equals(singerId))).findFirst();
    }

    public Optional<Instrumental> getInstrumentalById(InstrumentalId instrumentalId){
        return instrumentals().stream().filter((instrumental -> instrumental.identity().equals(instrumentalId))).findFirst();
    }

    public Optional<Lyrics> getLyricsById(LyricsId lyricsId){
        return lyrics.stream().filter((lyric -> lyric.identity().equals(lyricsId))).findFirst();
    }


    public ReleaseDate releaseDate() {
        return releaseDate;
    }

    public Title title() {
        return title;
    }

    public Set<Singer> singers() {
        return singers;
    }

    public Set<Instrumental> instrumentals() {
        return instrumentals;
    }

    public Set<Lyrics> lyrics() {
        return lyrics;
    }
}