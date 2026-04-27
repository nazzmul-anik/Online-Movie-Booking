package com.movieBooking.controller;

import com.movieBooking.model.dto.TheaterDTO;
import com.movieBooking.service.TheaterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/theater")
@RequiredArgsConstructor
public class TheaterController {

    private final TheaterService theaterService;

    @PostMapping("/add-theater")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> addTheater(@RequestBody TheaterDTO theaterDTO){
        TheaterDTO saveTheater = theaterService.addTheater(theaterDTO);
        return new ResponseEntity<>(saveTheater, HttpStatus.CREATED);
    }

    @GetMapping("/location")
    public ResponseEntity<?> getTheaterByLocation(@RequestParam String location){
        List<TheaterDTO> theaterDTO = theaterService.getTheaterByLocation(location);
        return new ResponseEntity<>(theaterDTO, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> updateTheater(@PathVariable Long id, @RequestBody TheaterDTO theaterDTO){
        TheaterDTO updatedTheater = theaterService.updateTheater(id, theaterDTO);
        return new ResponseEntity<>(updatedTheater, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deleteTheater(@PathVariable Long id){
        theaterService.deleteTheaterById(id);
        return new ResponseEntity<>("Delete theater successfully!!", HttpStatus.OK);
    }

}
