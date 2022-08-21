package com.sofka.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import com.sofka.domain.song.commands.CreateSong;
import com.sofka.domain.song.events.SongCreated;
import com.sofka.domain.song.values.IsRecorded;
import com.sofka.domain.song.values.ReleaseDate;
import com.sofka.domain.song.values.SongId;
import com.sofka.domain.song.values.Title;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CreateSongUseCaseTest {

    @Test
    public void createSongUseCaseTest(){
        CreateSong command = new CreateSong(new Title("Break up"), new ReleaseDate("19/10/2024"), new IsRecorded(false));
        CreateSongUseCase useCase = new CreateSongUseCase();

        var events = UseCaseHandler
                .getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(()->new IllegalArgumentException("Something went wrong creating song"))
                .getDomainEvents();

        SongCreated event = (SongCreated) events.get(0);

        Assertions.assertEquals(command.getReleaseDate().value(), event.getReleaseDate().value());
        Assertions.assertEquals(command.getTitle().value(), event.getTitle().value());

    }
}