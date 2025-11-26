package com.srt.bookmyshow_naga.service;

import com.srt.bookmyshow_naga.model.Seat;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;


public interface SeatService {
    public Seat getSeat(int seatNo);
    public List<Seat> getSeatsByScreenId(int screenId);
    public Seat addSeat(Seat seat,int screenId);
    public List<Seat> saveSeats(List<Seat> seats,int screenId);
}
