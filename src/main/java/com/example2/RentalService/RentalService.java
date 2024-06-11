package com.example2.RentalService;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class RentalService {

        public Movie getMovie(Long id){
            RestTemplate restTemplate = new RestTemplate();
            Movie mov = restTemplate.getForObject("http://localhost:8080/movies/"  + id, Movie.class);
            return mov;

        };

        public Movie returnMovie(Long id){
            RestTemplate restTemplate = new RestTemplate();
            //Movie mov = restTemplate.postForObject("http://localhost:8080/setTrue/"  + id,null, Movie.class);


            ResponseEntity<Movie> get = restTemplate.exchange("http://localhost:8080/setTrue/"  + id, HttpMethod.PUT, null, Movie.class);
            Movie mov = get.getBody();
        return mov;
        }

        public Movie rentMovie(Long id){
            RestTemplate restTemplate = new RestTemplate();
            Movie mov = restTemplate.patchForObject("http://localhost:8080/setFalse/"  + id,null, Movie.class);
            return mov;
        }
}
