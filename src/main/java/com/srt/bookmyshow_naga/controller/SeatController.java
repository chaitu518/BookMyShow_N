package com.srt.bookmyshow_naga.controller;

import com.srt.bookmyshow_naga.model.Seat;
import com.srt.bookmyshow_naga.service.SeatService;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/seats")
public class SeatController {
    private SeatService seatService;
    public SeatController(SeatService seatService) {
        this.seatService = seatService;
    }
    @PostMapping
    public Seat createSeat(@Param("screen_id") int screenId,@RequestBody Seat seat) {
        return seatService.addSeat(seat,screenId);
    }
    @GetMapping()
    public Seat getSeat(@Param("seat_id") int seatId) {
        return seatService.getSeat(seatId);
    }
    @PostMapping("/{screenId}")
    public List<Seat> createSeats(@PathVariable int screenId, @RequestBody List<Seat> seats) {
        return seatService.saveSeats(seats,screenId);
    }
    @GetMapping("/{screenId}")
    public List<Seat> getSeatByScreenId(@PathVariable int screenId) {
        return seatService.getSeatsByScreenId(screenId);
    }
}
