package com.codeclan.example.MovieDatabase.repository;

import com.codeclan.example.MovieDatabase.models.Director;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectorRepository extends JpaRepository<Director, Long> {
}
