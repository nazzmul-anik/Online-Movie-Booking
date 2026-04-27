package com.movieBooking.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Data
@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String genre;
    private Integer duration;
    private LocalDateTime releaseDateTime;
    private Set<String> languages;

    @OneToMany(mappedBy = "movie", fetch = FetchType.LAZY)
    private List<Show> shows;
}
