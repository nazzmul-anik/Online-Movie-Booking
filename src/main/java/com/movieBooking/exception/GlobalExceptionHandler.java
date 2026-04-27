package com.movieBooking.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException ex){
        ErrorResponse response = new ErrorResponse(ex.getMessage(), ex.getStatus());
        return new ResponseEntity<>(response, response.getStatus());
    }
}
