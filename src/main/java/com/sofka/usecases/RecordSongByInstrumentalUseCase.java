package com.sofka.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import com.sofka.domain.song.Song;
import com.sofka.domain.song.events.InstrumentalRecorded;
import com.sofka.domain.song.values.IsRecorded;
import com.sofka.domain.song.values.SongId;

public class RecordSongByInstrumentalUseCase extends UseCase<TriggeredEvent<InstrumentalRecorded>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<InstrumentalRecorded> instrumentalIsRecordedChanged) {
        InstrumentalRecorded event = instrumentalIsRecordedChanged.getDomainEvent();
        Song song = Song.from(SongId.of(event.aggregateRootId()),this.retrieveEvents());
        if(event.getIsRecorded().value()&&song.singer().isRecorded().value()){
            song.changeIsRecorded(new IsRecorded(true));
            emit().onResponse(new ResponseEvents(song.getUncommittedChanges()));
        }else {
            song.changeIsRecorded(new IsRecorded(false));
            emit().onResponse(new ResponseEvents(song.getUncommittedChanges()));
        }


    }
}
