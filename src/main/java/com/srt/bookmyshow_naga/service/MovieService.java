package com.srt.bookmyshow_naga.service;

import com.srt.bookmyshow_naga.model.Movie;

import java.util.Optional;

public interface MovieService {
    public Movie getMovieById(int id);
    public Movie addMovie(Movie movie);
}
