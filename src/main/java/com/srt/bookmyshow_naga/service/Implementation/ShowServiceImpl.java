package com.srt.bookmyshow_naga.service.Implementation;

import com.srt.bookmyshow_naga.model.Movie;
import com.srt.bookmyshow_naga.model.Screen;
import com.srt.bookmyshow_naga.model.Show;
import com.srt.bookmyshow_naga.repos.MovieRepository;
import com.srt.bookmyshow_naga.repos.ScreenRepository;
import com.srt.bookmyshow_naga.repos.ShowRepository;
import com.srt.bookmyshow_naga.service.ShowService;
import org.springframework.stereotype.Service;

@Service
public class ShowServiceImpl implements ShowService {
    private ShowRepository showRepository;
    private ScreenRepository screenRepository;
    private MovieRepository movieRepository;
    public ShowServiceImpl(ShowRepository showRepository, ScreenRepository screenRepository, MovieRepository movieRepository) {
        this.showRepository = showRepository;
        this.screenRepository = screenRepository;
        this.movieRepository = movieRepository;
    }
    @Override
    public Show getShow(int id) {
        return showRepository.findById(id).orElseThrow(()->new RuntimeException("Not found show with Id: "+id));
    }

    @Override
    public Show addShow(Show show, int screenId, int movieId) {
        Movie movie = movieRepository.findById(movieId).orElseThrow(()->new RuntimeException("Not found movie with Id: "+movieId));
        Screen screen = screenRepository.findById(screenId).orElseThrow(()->new RuntimeException("Not found screen with Id: "+screenId));
        show.setScreen(screen);
        show.setMovie(movie);
        return showRepository.save(show);
    }
}
