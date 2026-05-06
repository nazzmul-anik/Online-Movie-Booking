package com.movieBooking.service;

import com.movieBooking.model.dto.ShowDTO;
import com.movieBooking.model.entity.Show;

import java.util.List;

public interface ShowService {
    ShowDTO createShow(ShowDTO showDTO);

    List<ShowDTO> getAllShow();

    List<ShowDTO> getShowsByMovie(Long id);

    List<ShowDTO> getShowsByTheater(Long id);

    ShowDTO updateShow(Long id, ShowDTO showDTO);

    void deleteShow(Long id);
}
