package dev.spring.movie_recommendation.controllers;

import dev.spring.movie_recommendation.dtos.MovieDetailsDTO;
import dev.spring.movie_recommendation.dtos.MovieRecommendationsResponseDTO;
import dev.spring.movie_recommendation.dtos.MovieResponseDTO;
import dev.spring.movie_recommendation.services.MovieRecommendationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieRecommendationController {
    private MovieRecommendationService movieRecommendationService;

    public MovieRecommendationController(MovieRecommendationService movieRecommendationService) {
        this.movieRecommendationService = movieRecommendationService;
    }

    @GetMapping("/recommendations")
    public ResponseEntity<MovieRecommendationsResponseDTO> recommendationsByParams(@RequestParam(required = false)List<Long> genreIds, @RequestParam(required = false) Integer decade, @RequestParam(required = false) String sortBy,
                                                    @RequestParam(required = false) String mood, @RequestParam(required = false) String withOriginCountry, @RequestParam(required = false) String withOriginalLanguage, @RequestParam(required = false) Integer withRuntimeGte,
                                                    @RequestParam(required = false) Integer withRuntimeLte, @RequestParam(required = false) String responseLanguage, @RequestParam(required = false) Integer page) {
        MovieRecommendationsResponseDTO movieRecommendations = movieRecommendationService.recommendationsByParams(genreIds, decade, sortBy, mood, withOriginCountry, withOriginalLanguage, withRuntimeGte, withRuntimeLte, responseLanguage, page);
        return new ResponseEntity<>(movieRecommendations, HttpStatus.OK);
    }

    @GetMapping("/recommendations/random")
    public ResponseEntity<MovieResponseDTO> randomRecommendation(@RequestParam(required = false)List<Long> genreIds, @RequestParam(required = false) Integer decade, @RequestParam(required = false) String sortBy,
                                                                                   @RequestParam(required = false) String mood, @RequestParam(required = false) String withOriginCountry, @RequestParam(required = false) String withOriginalLanguage, @RequestParam(required = false) Integer withRuntimeGte,
                                                                                   @RequestParam(required = false) Integer withRuntimeLte, @RequestParam(required = false) String responseLanguage) {
        MovieResponseDTO movieRecommendations = movieRecommendationService.randomRecommendation(genreIds, decade, sortBy, mood, withOriginCountry, withOriginalLanguage, withRuntimeGte, withRuntimeLte, responseLanguage);
        return new ResponseEntity<>(movieRecommendations, HttpStatus.OK);
    }

    @GetMapping("{movieId}/details")
    public ResponseEntity<MovieDetailsDTO> getMovieDetails(@PathVariable Long movieId, @RequestParam(required = false) String responseLanguage) {
        MovieDetailsDTO movieDetails = movieRecommendationService.getMovieDetails(movieId, responseLanguage);
        return new ResponseEntity<>(movieDetails, HttpStatus.OK);
    }
}
