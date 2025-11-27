package com.srt.bookmyshow_naga.service.Implementation;

import com.srt.bookmyshow_naga.model.*;
import com.srt.bookmyshow_naga.repos.*;
import com.srt.bookmyshow_naga.service.ShowService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShowServiceImpl implements ShowService {
    private ShowRepository showRepository;
    private ScreenRepository screenRepository;
    private MovieRepository movieRepository;
    private SeatRepository seatRepository;
    private ShowSeatRepository showSeatRepository;
    public ShowServiceImpl(ShowRepository showRepository, ScreenRepository screenRepository, MovieRepository movieRepository, SeatRepository seatRepository, ShowSeatRepository showSeatRepository) {
        this.showRepository = showRepository;
        this.screenRepository = screenRepository;
        this.movieRepository = movieRepository;
        this.seatRepository = seatRepository;
        this.showSeatRepository = showSeatRepository;
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

        Show show1 = showRepository.save(show);
        List<Seat> seats = seatRepository.findByScreenId(screenId);
        List<ShowSeat> showSeats = new ArrayList<>();
        for (Seat seat : seats) {
            ShowSeat showSeat = new ShowSeat();
            showSeat.setSeat(seat);
            showSeat.setShow(show1);
            showSeat.setPrice(show1.getPrice());
            showSeats.add(showSeat);
        }
        showSeatRepository.saveAll(showSeats);
        return show1;
    }
}
