package com.codeclan.example.MovieDatabase.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "actors")
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany
    @JoinTable(
          name = "actors_films",
          joinColumns = { @JoinColumn(
                  name = "actor_id",
                  nullable = false,
                  updatable = false)
          },
          inverseJoinColumns = { @JoinColumn(
                  name = "film_id",
                  nullable = false,
                  updatable = false)
          }
    )
    private List<Film> filmography;

    public Actor(String name) {
        this.name = name;
        this.filmography = new ArrayList<Film>();
    }

    public Actor() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Film> getFilmography() {
        return filmography;
    }

    public void setFilmography(List<Film> filmography) {
        this.filmography = filmography;
    }

    public void addFilm(Film film){
        this.filmography.add(film);
    }
}
