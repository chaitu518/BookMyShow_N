package com.srt.bookmyshow_naga.controller;

import com.srt.bookmyshow_naga.model.Movie;
import com.srt.bookmyshow_naga.service.MovieService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/movies")
public class MovieController {
    private MovieService movieService;
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }
    @GetMapping("/{id}")
    public Movie getMovie(@PathVariable int id) {
        return movieService.getMovieById(id);

    }
    @PostMapping
    public Movie addMovie(@RequestBody Movie movie) {
        return movieService.addMovie(movie);
    }

}
