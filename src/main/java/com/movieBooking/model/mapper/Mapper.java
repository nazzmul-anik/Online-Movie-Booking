package com.movieBooking.model.mapper;

import com.movieBooking.model.dto.MovieDTO;
import com.movieBooking.model.dto.TheaterDTO;
import com.movieBooking.model.entity.Movie;
import com.movieBooking.model.entity.Theater;

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
        movie.setTitle(movieDTO.getTitle());
        movie.setDescription(movieDTO.getDescription());
        movie.setGenre(movieDTO.getGenre());
        movie.setDuration(movieDTO.getDuration());
        movie.setReleaseDateTime(movieDTO.getReleaseDateTime());
        movie.setLanguages(movieDTO.getLanguages());
        return movie;
    }

    public static TheaterDTO getDTO_From_Theater(Theater theater){
        TheaterDTO theaterDTO = new TheaterDTO();
        theaterDTO.setId(theater.getId());
        theaterDTO.setName(theater.getName());
        theaterDTO.setCapacity(theater.getCapacity());
        theaterDTO.setLocation(theater.getLocation());
        theaterDTO.setScreenType(theater.getScreenType());
        return theaterDTO;
    }

    public static Theater getTheater_From_DTO(TheaterDTO theaterDTO){
        Theater theater = new Theater();
        theater.setName(theaterDTO.getName());
        theater.setCapacity(theaterDTO.getCapacity());
        theater.setLocation(theaterDTO.getLocation());
        theater.setScreenType(theaterDTO.getScreenType());
        return theater;
    }
}
