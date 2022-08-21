package com.sofka.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import com.sofka.domain.generics.Name;
import com.sofka.domain.song.events.*;
import com.sofka.domain.song.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class RecordSongBySingerUseCaseTest {
    private final String ROOT_ID = "21fvcxsdss";

    @Mock
    private DomainEventRepository repository;

    //Instrumental already recorded and new Singer Recorded Event changed to true - That means Song is recorded (Expected true)
    @Test
    public void changeSongIsRecordedBySingerUseCaseTest1(){
        var event = new SingerRecorded(SingerId.of("gduuisnvi3"), new IsRecorded(true));
        var useCase = new RecordSongBySingerUseCase();
        event.setAggregateRootId(ROOT_ID);

        useCase.addRepository(repository);

        Mockito.when(repository.getEventsBy(ROOT_ID)).thenReturn(List.of(
                new SongCreated(
                        new Title("La Plata"),
                        new ReleaseDate("20/08/2022"),
                        new IsRecorded(false)
                ),
                new InstrumentalAdded(
                        InstrumentalId.of("asdssda12"),
                        new PercussionInstrument("Drums"),
                        new MelodicInstrument("Guitar"),
                        new IsRecorded(true)
                ),
                new SingerAdded(
                        SingerId.of("gfeve2"),
                        new Name("Diomedes Diaz"),
                        new VocalRegister("Tenor"),
                        new IsRecorded(false)
                )
        ));

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(ROOT_ID)
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();

        SongRecorded responseEvent = (SongRecorded) events.get(0);

        Assertions.assertEquals(responseEvent.getIsRecorded().value(), true);

        Mockito.verify(repository).getEventsBy(ROOT_ID);

    }

    //Instrumental not recorded yet and new Singer Recorded Event changed to true - That means Song is NOT recorded (Expected false)
    @Test
    public void changeSongIsRecordedBySingerUseCaseTest2(){
        var event = new SingerRecorded(SingerId.of("gduuisnvi3"), new IsRecorded(true));
        var useCase = new RecordSongBySingerUseCase();
        event.setAggregateRootId(ROOT_ID);

        useCase.addRepository(repository);

        Mockito.when(repository.getEventsBy(ROOT_ID)).thenReturn(List.of(
                new SongCreated(
                        new Title("La Plata"),
                        new ReleaseDate("20/08/2022"),
                        new IsRecorded(false)
                ),
                new InstrumentalAdded(
                        InstrumentalId.of("asdssda12"),
                        new PercussionInstrument("Drums"),
                        new MelodicInstrument("Guitar"),
                        new IsRecorded(false)
                ),
                new SingerAdded(
                        SingerId.of("gfeve2"),
                        new Name("Diomedes Diaz"),
                        new VocalRegister("Tenor"),
                        new IsRecorded(false)
                )
        ));

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(ROOT_ID)
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();

        SongRecorded responseEvent = (SongRecorded) events.get(0);

        Assertions.assertEquals(responseEvent.getIsRecorded().value(), false);

        Mockito.verify(repository).getEventsBy(ROOT_ID);

    }

    //Instrumental not recorded yet and new Singer Recorded Event changed to false - That means Song is NOT recorded (Expected false)
    @Test
    public void changeSongIsRecordedBySingerUseCaseTest3(){
        var event = new SingerRecorded(SingerId.of("gduuisnvi3"), new IsRecorded(false));
        var useCase = new RecordSongBySingerUseCase();
        event.setAggregateRootId(ROOT_ID);

        useCase.addRepository(repository);

        Mockito.when(repository.getEventsBy(ROOT_ID)).thenReturn(List.of(
                new SongCreated(
                        new Title("La Plata"),
                        new ReleaseDate("20/08/2022"),
                        new IsRecorded(false)
                ),
                new InstrumentalAdded(
                        InstrumentalId.of("asdssda12"),
                        new PercussionInstrument("Drums"),
                        new MelodicInstrument("Guitar"),
                        new IsRecorded(false)
                ),
                new SingerAdded(
                        SingerId.of("gfeve2"),
                        new Name("Diomedes Diaz"),
                        new VocalRegister("Tenor"),
                        new IsRecorded(true)
                )
        ));

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(ROOT_ID)
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();

        SongRecorded responseEvent = (SongRecorded) events.get(0);

        Assertions.assertEquals(responseEvent.getIsRecorded().value(), false);

        Mockito.verify(repository).getEventsBy(ROOT_ID);

    }

    //Instrumental recorded and new Singer Recorded Event changed to false - That means Song is NOT recorded (Expected false)
    @Test
    public void changeSongIsRecordedBySingerUseCaseTest4(){
        var event = new SingerRecorded(SingerId.of("gduuisnvi3"), new IsRecorded(false));
        var useCase = new RecordSongBySingerUseCase();
        event.setAggregateRootId(ROOT_ID);

        useCase.addRepository(repository);

        Mockito.when(repository.getEventsBy(ROOT_ID)).thenReturn(List.of(
                new SongCreated(
                        new Title("La Plata"),
                        new ReleaseDate("20/08/2022"),
                        new IsRecorded(false)
                ),
                new InstrumentalAdded(
                        InstrumentalId.of("asdssda12"),
                        new PercussionInstrument("Drums"),
                        new MelodicInstrument("Guitar"),
                        new IsRecorded(true)
                ),
                new SingerAdded(
                        SingerId.of("gfeve2"),
                        new Name("Diomedes Diaz"),
                        new VocalRegister("Tenor"),
                        new IsRecorded(true)
                )
        ));

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(ROOT_ID)
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();

        SongRecorded responseEvent = (SongRecorded) events.get(0);

        Assertions.assertEquals(responseEvent.getIsRecorded().value(), false);

        Mockito.verify(repository).getEventsBy(ROOT_ID);

    }



}