package com.movieBooking.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Theater {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String location;
    private Integer capacity;
    private String screenType;

    @OneToMany(mappedBy = "theater", fetch = FetchType.LAZY)
    private List<Show> shows;
}
