package com.srt.bookmyshow_naga.service.Implementation;

import com.srt.bookmyshow_naga.model.Movie;
import com.srt.bookmyshow_naga.repos.MovieRepository;
import com.srt.bookmyshow_naga.service.MovieService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {
    private MovieRepository movieRepository;
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
    @Override
    public Movie getMovieById(int id) {
        return movieRepository.findById(id).orElseThrow(()-> new RuntimeException("Movie not found with id: " + id));
    }

    @Override
    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }
}
