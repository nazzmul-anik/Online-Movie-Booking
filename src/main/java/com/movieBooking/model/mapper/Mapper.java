package com.movieBooking.model.mapper;

import com.movieBooking.model.dto.MovieDTO;
import com.movieBooking.model.entity.Movie;

public class Mapper {
    public static MovieDTO getDTO_From_Movie(Movie movie){
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setId(movie.getId());
        movieDTO.setTitle(movie.getTitle());
        movieDTO.setDescription(movie.getDescription());
        movieDTO.setGenre(movie.getGenre());
        movieDTO.setDuration(movie.getDuration());
        movieDTO.setReleaseDateTime(movie.getReleaseDateTime());
        movieDTO.setLanguages(movie.getLanguages());
        return movieDTO;
    }

    public static Movie getMovie_From_DTO(MovieDTO movieDTO){
        Movie movie = new Movie();
        movie.setId(movieDTO.getId());
        movie.setTitle(movieDTO.getTitle());
        movie.setDescription(movieDTO.getDescription());
        movie.setGenre(movieDTO.getGenre());
        movie.setDuration(movieDTO.getDuration());
        movie.setReleaseDateTime(movieDTO.getReleaseDateTime());
        movie.setLanguages(movieDTO.getLanguages());
        return movie;
    }
}
