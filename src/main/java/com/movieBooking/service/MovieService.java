package com.movieBooking.service;

import com.movieBooking.model.dto.MovieDTO;

import java.util.List;
import java.util.Set;

public interface MovieService {
    MovieDTO addNewMovie(MovieDTO movieDTO);

    List<MovieDTO> getAllMovies();

    List<MovieDTO> getMoviesByGenre(String genre);

    List<MovieDTO> getMoviesByLanguages(Set<String> languages);

    MovieDTO getMovieByTitle(String title);

    MovieDTO updateMovie(Long id, MovieDTO movieDTO);

    void deleteMovie(Long id);
}
