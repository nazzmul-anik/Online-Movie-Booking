package com.movieBooking.service.impl;

import com.movieBooking.exception.ResourceNotFoundException;
import com.movieBooking.model.dto.TheaterDTO;
import com.movieBooking.model.entity.Theater;
import com.movieBooking.model.mapper.Mapper;
import com.movieBooking.repository.TheaterRepository;
import com.movieBooking.service.TheaterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TheaterServiceImpl implements TheaterService {

    private final TheaterRepository theaterRepository;

    @Override
    public TheaterDTO addTheater(TheaterDTO theaterDTO) {
        Theater theater = Mapper.getTheater_From_DTO(theaterDTO);
        theaterRepository.save(theater);
        return Mapper.getDTO_From_Theater(theater);
    }

    @Override
    public List<TheaterDTO> getTheaterByLocation(String location) {
        List<Theater> theaterList = theaterRepository.findByLocation(location);
        if(theaterList.isEmpty()){
            throw new ResourceNotFoundException("No theaters are found on this entered location: "+location);
        }
        return theaterList.stream().map(Mapper::getDTO_From_Theater).toList();
    }

    @Override
    public TheaterDTO updateTheater(Long id, TheaterDTO theaterDTO) {
        Theater theater = theaterRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("No theater is found for the id: "+id));
        theater = Mapper.getTheater_From_DTO(theaterDTO);
        theaterRepository.save(theater);
        return Mapper.getDTO_From_Theater(theater);
    }

    @Override
    public void deleteTheaterById(Long id) {
        if(!theaterRepository.existsById(id))
            throw new ResourceNotFoundException("No theater is found for the id: "+id);
        theaterRepository.deleteById(id);
    }
}
