package com.codeclan.example.MovieDatabase.repository;

import com.codeclan.example.MovieDatabase.models.Film;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FilmRepository extends JpaRepository<Film, Long> {
}
