package com.example2.RentalService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.NoSuchElementException;

import static org.springframework.http.ResponseEntity.notFound;


@org.springframework.web.bind.annotation.RestController
@RequestMapping("")
public class RestController {

    private final RentalService rentalService;

    public RestController(RentalService rentalService){
        this.rentalService=rentalService;
    }

    @GetMapping("/getMovie")
    public ResponseEntity<Movie> getMovieById(@RequestParam Long id){

        return ResponseEntity.ok(rentalService.getMovie(id));
    }
    @GetMapping("/returnMovie")
    public ResponseEntity<Movie> returnMovie(@RequestParam Long id){

        return ResponseEntity.ok(rentalService.returnMovie(id));
    }
    @GetMapping("/rentMovie")
    public ResponseEntity<Movie> rentMovie(@RequestParam Long id){
        return ResponseEntity.ok(rentalService.rentMovie(id));
    }

}
