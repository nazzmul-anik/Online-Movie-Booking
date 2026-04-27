package com.movieBooking.controller;

import com.movieBooking.model.dto.MovieDTO;
import com.movieBooking.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/movies")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @PostMapping("/add-movie")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> addNewMovie(@RequestBody MovieDTO movieDTO){
        MovieDTO createdMovie = movieService.addNewMovie(movieDTO);
        return new ResponseEntity<>(createdMovie, HttpStatus.CREATED);
    }

    @GetMapping("/list/all")
    public ResponseEntity<?> getAllMovies(){
        List<MovieDTO> allMovies = movieService.getAllMovies();
        return new ResponseEntity<>(allMovies, HttpStatus.OK);
    }

    @GetMapping("/list/by-genre")
    public ResponseEntity<?> getMoviesByGenre(@RequestParam String genre){
        List<MovieDTO> movieList = movieService.getMoviesByGenre(genre);
        return new ResponseEntity<>(movieList, HttpStatus.OK);
    }

    @GetMapping("/list/by-language")
    public ResponseEntity<?> getMoviesByLanguage(@RequestParam(required = true) Set<String> language){
        List<MovieDTO> movieList = movieService.getMoviesByLanguages(language);
        return new ResponseEntity<>(movieList, HttpStatus.OK);
    }

    @GetMapping("/by-title")
    public ResponseEntity<?> getMovieByTitle(@RequestParam String title){
        MovieDTO movie = movieService.getMovieByTitle(title);
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> updateMovie(@PathVariable Long id, @RequestBody MovieDTO movieDTO){
        MovieDTO updatedMovie = movieService.updateMovie(id, movieDTO);
        return new ResponseEntity<>(updatedMovie, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deleteMovie(@PathVariable Long id){
        movieService.deleteMovie(id);
        return new ResponseEntity<>("Delete Movie Successfully!!", HttpStatus.OK);
    }
}
