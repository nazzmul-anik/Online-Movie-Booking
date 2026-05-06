package com.movieBooking.controller;

import com.movieBooking.model.dto.ShowDTO;
import com.movieBooking.model.entity.Show;
import com.movieBooking.service.ShowService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/show")
@RequiredArgsConstructor
public class ShowController {

    private final ShowService showService;

    @PostMapping("/add-show")
    public ResponseEntity<?> createShow(@RequestBody ShowDTO showDTO){
        ShowDTO createdShow = showService.createShow(showDTO);
        return new ResponseEntity<>(createdShow, HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ResponseEntity<?> getAllShows(){
        List<ShowDTO> showList = showService.getAllShow();
        return ResponseEntity.ok(showList);
    }

    @GetMapping("/list/by-movie/{id}")
    public ResponseEntity<?> getShowsByMovie(@PathVariable Long id){
        List<ShowDTO> showList = showService.getShowsByMovie(id);
        return ResponseEntity.ok(showList);
    }

    @GetMapping("/list/by-theater/{id}")
    public ResponseEntity<?> getShowsByTheater(@PathVariable Long id){
        List<ShowDTO> showList = showService.getShowsByTheater(id);
        return  ResponseEntity.ok(showList);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateShow(@PathVariable Long id, @RequestBody ShowDTO showDTO){
        ShowDTO updatedShow = showService.updateShow(id, showDTO);
        return ResponseEntity.ok(updatedShow);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteShow(@PathVariable Long id){
        showService.deleteShow(id);
        return new ResponseEntity<>("Delete Show Successfully !!", HttpStatus.OK);
    }
}
