package com.example2.RentalService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.NoSuchElementException;

import static org.springframework.http.HttpEntity.EMPTY;
import static org.springframework.http.ResponseEntity.notFound;


@org.springframework.web.bind.annotation.RestController
@RequestMapping("")
public class RestController {

    private final RentalService rentalService;

    public RestController(RentalService rentalService){
        this.rentalService=rentalService;
    }



    @Operation(summary = "Pokaz film", description = "Wyświela film o podanym id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
            @ApiResponse(responseCode = "404", description = "nie ma filmu o tym id")
    })
    @GetMapping("/getMovie")
    public ResponseEntity<Movie> getMovieById(@RequestParam Long id){

        return ResponseEntity.ok(rentalService.getMovie(id));
    }
    @Operation(summary = "oddaj film", description = "film avaiblity ustaw na true")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "film dostaje true"),
            @ApiResponse(responseCode = "404", description = "nie znaleziono filmu do aktualiacji",useReturnTypeSchema = false ,content = {})
    })
    @PutMapping("/returnMovie")
    public ResponseEntity<Movie> returnMovie(@RequestParam @Parameter(name = "id", description = "id filmu w bazie", example = "1") Long id){

        return ResponseEntity.ok(rentalService.returnMovie(id));
    }

    @Operation(summary = "wypozycz film", description = "film avaiblity ustaw na false")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "film ma false"),
            @ApiResponse(responseCode = "404", description = "nie znaleziono filmu do aktualiacji")
    })
    @PostMapping("/rentMovie")
    public ResponseEntity<Movie> rentMovie(@RequestParam Long id){
        return ResponseEntity.ok(rentalService.rentMovie(id));
    }
    @Operation(summary = "rzuca błędem 500", description = "rzuca błędem 500")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "500", description = "rzuca błędem 500"),
    })
    @GetMapping("/get500")
    public ResponseEntity<Exception> get500(){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Exception> mov = restTemplate.getForObject("http://localhost:8080/throw500", ResponseEntity.class);
        return mov;
    }

}
