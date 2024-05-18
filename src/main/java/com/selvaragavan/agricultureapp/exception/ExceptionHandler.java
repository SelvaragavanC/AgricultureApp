package com.selvaragavan.agricultureapp.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.util.InputMismatchException;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(InputMismatchException.class)
    public ResponseEntity<ErrorResponse> handleInputMismatchException(InputMismatchException e) {
        ErrorResponse err = ErrorResponse.builder().message(e.getMessage()).build();
        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handler(Exception ex){
        ErrorResponse err = ErrorResponse.builder().message(ex.getMessage()).build();
        return new ResponseEntity<>(err, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
