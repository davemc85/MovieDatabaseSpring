package com.codeclan.example.MovieDatabase.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "films")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "director_id", nullable = false)
    private Director director;

    @Column(name = "genre")
    @Enumerated(value = EnumType.STRING)
    private FilmType genre;

    @ManyToMany
    @JoinTable(
            name = "actors_films",
            joinColumns = { @JoinColumn(
                    name = "film_id",
                    nullable = false,
                    updatable = false)
            },
            inverseJoinColumns = { @JoinColumn(
                    name = "actor_id",
                    nullable = false,
                    updatable = false)

            }
    )
    private List<Actor> cast;

    public Film(String name, Director director, FilmType genre) {
        this.name = name;
        this.director = director;
        this.genre = genre;
        this.cast = new ArrayList<Actor>();
    }

    public Film() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public FilmType getGenre() {
        return genre;
    }

    public void setGenre(FilmType genre) {
        this.genre = genre;
    }

    public List<Actor> getCast() {
        return cast;
    }

    public void setCast(List<Actor> cast) {
        this.cast = cast;
    }

    public void addActor(Actor actor){
        this.cast.add(actor);
    }
}
