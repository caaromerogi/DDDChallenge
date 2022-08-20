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
class ChangeSongIsRecordedBySingerUseCaseTest {
    private final String ROOT_ID = "21fvcxsdss";

    @Mock
    private DomainEventRepository repository;

    @Test
    public void changeSongIsRecordedBySingerUseCaseTest1(){
        var event = new SingerIsRecordedChanged(SingerId.of("gduuisnvi3"), new IsRecorded(false));
        var useCase = new ChangeSongIsRecordedBySingerUseCase();
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

        SongIsRecordedChanged responseEvent = (SongIsRecordedChanged) events.get(0);

        Assertions.assertEquals(responseEvent.getIsRecorded().value(), false);

        Mockito.verify(repository).getEventsBy(ROOT_ID);

    }

}