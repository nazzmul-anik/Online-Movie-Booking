package com.movieBooking.service.impl;

import com.movieBooking.exception.ResourceNotFoundException;
import com.movieBooking.model.dto.ShowDTO;
import com.movieBooking.model.entity.Booking;
import com.movieBooking.model.entity.Movie;
import com.movieBooking.model.entity.Show;
import com.movieBooking.model.entity.Theater;
import com.movieBooking.model.mapper.Mapper;
import com.movieBooking.repository.MovieRepository;
import com.movieBooking.repository.ShowRepository;
import com.movieBooking.repository.TheaterRepository;
import com.movieBooking.service.ShowService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShowServiceImpl implements ShowService {

    private final ShowRepository showRepository;
    private final MovieRepository movieRepository;
    private final TheaterRepository theaterRepository;

    @Override
    public ShowDTO createShow(ShowDTO showDTO) {
        Movie movie = movieRepository.findById(showDTO.getMovieId())
                .orElseThrow(() -> new ResourceNotFoundException("Movie Not Found for id: " + showDTO.getMovieId()));
        Theater theater = theaterRepository.findById(showDTO.getTheaterId())
                .orElseThrow(() -> new ResourceNotFoundException("Theater Not Found for id: " + showDTO.getTheaterId()));

        Show show = Mapper.getShow_From_DTO(showDTO);
        show.setMovie(movie);
        show.setTheater(theater);
        showRepository.save(show);
        return Mapper.getDTO_From_Show(show);
    }

    @Override
    public List<ShowDTO> getAllShow() {
        List<Show> showList = showRepository.findAll();
        return showList.stream().map(Mapper::getDTO_From_Show)
                .toList();
    }

    @Override
    public List<ShowDTO> getShowsByMovie(Long id) {
        List<Show> showList = showRepository.findByMovieId(id);
        if(showList.isEmpty()) {
            throw new ResourceNotFoundException("Movie Not Found for id: " + id);
        }
        return showList.stream().map(Mapper::getDTO_From_Show).toList();
    }

    @Override
    public List<ShowDTO> getShowsByTheater(Long id) {
        List<Show> showList = showRepository.findByTheaterId(id);
        if(showList.isEmpty()) {
            throw new ResourceNotFoundException("Theater Not Found for id: " + id);
        }
        return showList.stream().map(Mapper::getDTO_From_Show).toList();
    }

    @Override
    public ShowDTO updateShow(Long id, ShowDTO showDTO) {
        Show show = showRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Show Not Found for id: " + id));
        Movie movie = movieRepository.findById(showDTO.getMovieId())
                .orElseThrow(() -> new ResourceNotFoundException("Movie Not Found for id: " + showDTO.getMovieId()));
        Theater theater = theaterRepository.findById(showDTO.getTheaterId())
                .orElseThrow(() -> new ResourceNotFoundException("Theater Not Found for id: " + showDTO.getTheaterId()));

        Show updateShow = Mapper.getShow_From_DTO(showDTO);
        updateShow.setMovie(movie);
        updateShow.setTheater(theater);
        showRepository.save(show);
        return Mapper.getDTO_From_Show(updateShow);
    }

    @Override
    public void deleteShow(Long id) {
        Show show = showRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Show Not Found for id: " + id));

       if(show.getBookings() != null && !show.getBookings().isEmpty()) {
           throw new IllegalStateException("Can't delete show because bookings exist.");
       }

        showRepository.deleteById(id);
    }
}
