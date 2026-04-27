package com.movieBooking.service;

import com.movieBooking.model.dto.TheaterDTO;

import java.util.List;

public interface TheaterService {
    TheaterDTO addTheater(TheaterDTO theaterDTO);

    List<TheaterDTO> getTheaterByLocation(String location);

    TheaterDTO updateTheater(Long id, TheaterDTO theaterDTO);

    void deleteTheaterById(Long id);
}
