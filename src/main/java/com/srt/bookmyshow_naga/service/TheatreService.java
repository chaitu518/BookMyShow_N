package com.srt.bookmyshow_naga.service;

import com.srt.bookmyshow_naga.model.Theatre;

import java.util.List;

public interface TheatreService {
    public List<Theatre> getTheatresByCityId(int city_Id);
    public List<Theatre> addAllCityTheatres(int city_Id, List<Theatre> theatres);
}
