package com.movieBooking.repository;

import com.movieBooking.model.entity.Show;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShowRepository extends JpaRepository<Show, Long> {
   List<Show> findByMovieId(Long movieId);
   List<Show> findByTheaterId(Long theaterId);

}
