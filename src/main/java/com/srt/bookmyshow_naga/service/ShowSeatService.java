package com.srt.bookmyshow_naga.service;

import com.srt.bookmyshow_naga.model.ShowSeat;

import java.util.List;

public interface ShowSeatService {
    public List<ShowSeat> findAllShowSeats(int showId);
}
