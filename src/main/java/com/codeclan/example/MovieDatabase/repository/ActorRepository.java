package com.codeclan.example.MovieDatabase.repository;

import com.codeclan.example.MovieDatabase.models.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor, Long> {
}
