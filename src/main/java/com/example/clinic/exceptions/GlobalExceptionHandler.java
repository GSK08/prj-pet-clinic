package com.example.clinic.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {PetNotFoundException.class})
    public ResponseEntity<Object> handleNotFound(Exception e){
        return new ResponseEntity<>(new ApiException(
                e.getCause(),
                e.getMessage(),
                ZonedDateTime.now()
        ), HttpStatus.NOT_FOUND);
    }

}
