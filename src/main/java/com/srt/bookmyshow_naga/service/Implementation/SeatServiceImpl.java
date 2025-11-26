package com.srt.bookmyshow_naga.service.Implementation;

import com.srt.bookmyshow_naga.model.Screen;
import com.srt.bookmyshow_naga.model.Seat;
import com.srt.bookmyshow_naga.repos.ScreenRepository;
import com.srt.bookmyshow_naga.repos.SeatRepository;
import com.srt.bookmyshow_naga.service.SeatService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SeatServiceImpl implements SeatService {
    private SeatRepository seatRepository;
    private ScreenRepository screenRepository;
    public SeatServiceImpl(SeatRepository seatRepository, ScreenRepository screenRepository) {
        this.seatRepository = seatRepository;
        this.screenRepository = screenRepository;
    }
    @Override
    public Seat getSeat(int seatId) {
        return seatRepository.findById(seatId).orElseThrow(() -> new RuntimeException("Seat Not Found with Id: " + seatId));
    }

    @Override
    public List<Seat> getSeatsByScreenId(int screenId) {
        return seatRepository.findByScreenId(screenId);
    }

    @Override
    public Seat addSeat(Seat seat,int screenId) {
        Screen screen = screenRepository.findById(screenId).orElseThrow(() -> new RuntimeException("Screen Not Found with Id: " + screenId));
        seat.setScreen(screen);
        return seatRepository.save(seat);
    }
    public List<Seat> saveSeats(List<Seat> seats,int screenId) {
        Screen screen = screenRepository.findById(screenId).orElseThrow(() -> new RuntimeException("Screen Not Found with Id: " + screenId));
        for (Seat seat : seats) {
            seat.setScreen(screen);
        }
        return seatRepository.saveAll(seats);
    }
}
