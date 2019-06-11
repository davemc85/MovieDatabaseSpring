package com.codeclan.example.MovieDatabase.components;

import com.codeclan.example.MovieDatabase.models.Actor;
import com.codeclan.example.MovieDatabase.models.Director;
import com.codeclan.example.MovieDatabase.models.Film;
import com.codeclan.example.MovieDatabase.models.FilmType;
import com.codeclan.example.MovieDatabase.repository.ActorRepository;
import com.codeclan.example.MovieDatabase.repository.DirectorRepository;
import com.codeclan.example.MovieDatabase.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    DirectorRepository directorRepository;

    @Autowired
    FilmRepository filmRepository;

    @Autowired
    ActorRepository actorRepository;

    public DataLoader() {
    }

    public void run(ApplicationArguments args){
        Director lasseter = new Director("John Lasseter");
        directorRepository.save(lasseter);

        Film toyStory = new Film("Toy Story", lasseter, FilmType.CHILDRENS);
        filmRepository.save(toyStory);

        Actor hanks = new Actor("Tom Hanks");
        actorRepository.save(hanks);

        Actor damon = new Actor("Matt Damon");
        actorRepository.save(damon);

        Actor allen = new Actor("Tim Allen");
        actorRepository.save(allen);

        Director spielberg = new Director("Steven Spielberg");
        directorRepository.save(spielberg);

        Film privateRyan = new Film("Saving Private Ryan", spielberg, FilmType.DRAMA);
        filmRepository.save(privateRyan);

        privateRyan.addActor(hanks);
        toyStory.addActor(hanks);
        actorRepository.save(hanks);

        privateRyan.addActor(damon);
        actorRepository.save(damon);

        toyStory.addActor(allen);
        actorRepository.save(allen);

        hanks.addFilm(privateRyan);
        hanks.addFilm(toyStory);
        actorRepository.save(hanks);

        allen.addFilm(toyStory);
        actorRepository.save(allen);

        damon.addFilm(privateRyan);
        actorRepository.save(damon);
    }
}
