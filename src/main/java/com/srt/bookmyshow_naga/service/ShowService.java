package com.srt.bookmyshow_naga.service;

import com.srt.bookmyshow_naga.model.Show;
import com.srt.bookmyshow_naga.model.dto.Availability;

public interface ShowService {
    public Show getShow(int id);
    public Show addShow(Show show,int screenId,int movieId);
    public Availability findAvailability(int showId);
}
