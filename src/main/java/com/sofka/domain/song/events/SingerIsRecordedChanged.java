package com.sofka.domain.song.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.domain.song.values.IsRecorded;
import com.sofka.domain.song.values.SingerId;

public class SingerIsRecordedChanged extends DomainEvent {
    private final SingerId singerId;
    private final IsRecorded isRecorded;


    public SingerIsRecordedChanged(SingerId singerId,IsRecorded isRecorded) {
        super("com.sofka.dddchallenge.Song.SingerIsRecordedChanged");
        this.isRecorded = isRecorded;
        this.singerId = singerId;
    }

    public IsRecorded getIsRecorded() {
        return isRecorded;
    }

    public SingerId getSingerId() {
        return singerId;
    }
}
