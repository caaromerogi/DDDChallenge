package com.sofka.domain.song.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.domain.song.values.*;

public class AddInstrumental extends Command {

    private final SongId songId;

    private final InstrumentalId instrumentalId;

    private final PercussionInstrument percussionInstrument;

    private final MelodicInstrument melodicInstrument;

    private final IsRecorded isRecorded;

    public AddInstrumental(SongId songId, InstrumentalId instrumentalId,
                           PercussionInstrument percussionInstrument,
                           MelodicInstrument melodicInstrument,
                           IsRecorded isRecorded) {
        this.songId = songId;
        this.instrumentalId = instrumentalId;
        this.percussionInstrument = percussionInstrument;
        this.melodicInstrument = melodicInstrument;
        this.isRecorded = isRecorded;
    }

    public SongId getSongId() {
        return songId;
    }

    public InstrumentalId getInstrumentalId() {
        return instrumentalId;
    }

    public PercussionInstrument getPercussionInstrument() {
        return percussionInstrument;
    }

    public MelodicInstrument getMelodicInstrument() {
        return melodicInstrument;
    }

    public IsRecorded getIsRecorded() {
        return isRecorded;
    }
}
