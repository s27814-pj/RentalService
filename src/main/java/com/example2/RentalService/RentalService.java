package com.example2.RentalService;

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
            Movie mov = restTemplate.getForObject("http://localhost:8080/setTrue/"  + id, Movie.class);
        return mov;
        }

        public Movie rentMovie(Long id){
            RestTemplate restTemplate = new RestTemplate();
            Movie mov = restTemplate.getForObject("http://localhost:8080/setFalse/"  + id, Movie.class);
            return mov;
        }
}
