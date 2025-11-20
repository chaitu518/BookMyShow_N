package com.srt.bookmyshow_naga.service;

import com.srt.bookmyshow_naga.model.City;

import java.util.List;
import java.util.Optional;

public interface CityService {
    public List<City> findAllCities();
    public Optional<City> findCityById(int id);
    public List<City> addAllCities(List<City> cities);
    public City addCity(City city);
}
