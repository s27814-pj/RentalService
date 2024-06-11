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
    @PutMapping("/returnMovie")
    public ResponseEntity<Movie> returnMovie(@RequestParam Long id){

        return ResponseEntity.ok(rentalService.returnMovie(id));
    }
    @PostMapping("/rentMovie")
    public ResponseEntity<Movie> rentMovie(@RequestParam Long id){
        return ResponseEntity.ok(rentalService.rentMovie(id));
    }
    @GetMapping("/get500")
    public ResponseEntity<Exception> get500(){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Exception> mov = restTemplate.getForObject("http://localhost:8080/throw500", ResponseEntity.class);
        return mov;
    }

}
