package com.pickme.calendar.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<?> handleCustomException(CustomException e){
        return ResponseEntity.status(e.getErrorCode().getHttpStatus()).body(e.getErrorCode().name() + ": " + e.getMessage());
    }
}
