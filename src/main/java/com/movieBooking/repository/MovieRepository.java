package com.movieBooking.repository;

import com.movieBooking.model.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    Optional<List<Movie>> findByGenre(String genre);
    Optional<List<Movie>> findByLanguages(Set<String> languages);
    Optional<Movie> findMovieByTitle(String title);
}
