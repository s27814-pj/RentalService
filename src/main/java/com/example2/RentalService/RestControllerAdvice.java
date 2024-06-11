package com.example2.RentalService;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import java.net.ConnectException;
import java.util.NoSuchElementException;

@org.springframework.web.bind.annotation.RestControllerAdvice
public class RestControllerAdvice {

    @ExceptionHandler
    public ResponseEntity<String> handleHttpClientErrorException$NotFound(HttpClientErrorException.NotFound exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("404 not found");
    }

    @ExceptionHandler
    public ResponseEntity<String> handleHttpClientErrorException$BadRequest(HttpClientErrorException.BadRequest exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("400 Bad_Request");
    }

    @ExceptionHandler
    public ResponseEntity<String> handleHttpServerErrorException$InternalServerError(HttpServerErrorException.InternalServerError exception) {
        return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("502 Bad_Gateway");
    }

    @ExceptionHandler
    public ResponseEntity<String> handleConnectException(ConnectException exception) {
        return ResponseEntity.status(HttpStatus.GATEWAY_TIMEOUT).body("no connection");
    }




}
