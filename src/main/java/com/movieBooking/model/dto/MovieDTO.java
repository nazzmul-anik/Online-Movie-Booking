package com.movieBooking.model.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Data
public class MovieDTO {
    private Long id;
    private String title;
    private String description;
    private String genre;
    private Integer duration;
    private LocalDateTime releaseDateTime;
    private Set<String> languages;
}
