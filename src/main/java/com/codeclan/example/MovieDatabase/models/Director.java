package com.codeclan.example.MovieDatabase.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "directors")
public class Director {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "director")
    private List<Film> filmography;

    public Director(String name) {
        this.name = name;
        this.filmography = new ArrayList<Film>();
    }

    public Director() {
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
}
