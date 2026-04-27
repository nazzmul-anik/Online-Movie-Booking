package com.movieBooking.model.dto;

import lombok.Data;

@Data
public class TheaterDTO {
    private Long id;
    private String name;
    private String location;
    private Integer capacity;
    private String screenType;
}
