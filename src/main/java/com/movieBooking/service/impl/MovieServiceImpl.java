package com.movieBooking.service.impl;


import com.movieBooking.exception.ResourceNotFoundException;
import com.movieBooking.model.dto.MovieDTO;
import com.movieBooking.model.entity.Movie;
import com.movieBooking.model.mapper.Mapper;
import com.movieBooking.repository.MovieRepository;
import com.movieBooking.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    @Override
    public MovieDTO addNewMovie(MovieDTO movieDTO) {
        Movie movie = Mapper.getMovie_From_DTO(movieDTO);
        movieRepository.save(movie);
        return Mapper.getDTO_From_Movie(movie);
    }

    @Override
    public List<MovieDTO> getAllMovies() {
        List<Movie> allMovies = movieRepository.findAll();
        return allMovies.stream().map(Mapper::getDTO_From_Movie).toList();
    }

    @Override
    public List<MovieDTO> getMoviesByGenre(String genre) {
        List<Movie> movieList = movieRepository.findByGenre(genre);
        if(movieList.isEmpty())
            throw new ResourceNotFoundException("No movies found for genre: "+genre);
        return movieList.stream().map(Mapper::getDTO_From_Movie).toList();
    }

    @Override
    public List<MovieDTO> getMoviesByLanguages(Set<String> language) {
        if(language == null || language.isEmpty()){
            return getAllMovies();
        }
        List<Movie> movieList = movieRepository.findByLanguages(language);
        if(movieList.isEmpty())
            throw new ResourceNotFoundException("No movies found for this languages: "+language);
        return movieList.stream().map(Mapper::getDTO_From_Movie).toList();
    }

    @Override
    public MovieDTO getMovieByTitle(String title) {
        Movie movie = movieRepository.findMovieByTitle(title)
                .orElseThrow(()-> new ResourceNotFoundException("No movie is found for this title: "+title));

        return Mapper.getDTO_From_Movie(movie);
    }

    @Override
    public MovieDTO updateMovie(Long id, MovieDTO movieDTO) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("NO movie found for the id: "+id));
        movie = Mapper.getMovie_From_DTO(movieDTO);
        movieRepository.save(movie);
        return Mapper.getDTO_From_Movie(movie);
    }

    @Override
    public void deleteMovie(Long id) {
        if(!movieRepository.existsById(id))
            throw new ResourceNotFoundException("No movie found for the id: "+id);
        movieRepository.deleteById(id);
    }
}
