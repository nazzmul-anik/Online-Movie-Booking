package com.movieBooking.model.dto;

import com.movieBooking.model.entity.Movie;
import com.movieBooking.model.entity.Theater;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ShowDTO {
    private Long id;
    private LocalDateTime showTime;
    private Double price;
    private Long movieId;
    private Long theaterId;
    private Movie movie;
    private Theater theater;
}
