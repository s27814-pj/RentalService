package com.example2.RentalService;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.NoSuchElementException;

@org.springframework.web.bind.annotation.RestControllerAdvice
public class RestControllerAdvice {


    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    ErrorResponse entityNotFoundHandler(EntityNotFoundException ex){
        return getErrorResponse(ex, "No item found.");

        public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

        @ExceptionHandler(value = {ResourceNotFoundException.class, CertainException.class})
        @ResponseStatus(value = HttpStatus.NOT_FOUND)
        public ErrorMessage resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
            ErrorMessage message = new ErrorMessage(
                    status,
                    date,
                    ex.getMessage(),
                    description);

            return message;
        }

}
