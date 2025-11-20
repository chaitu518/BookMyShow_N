package com.srt.bookmyshow_naga.controller;

import com.srt.bookmyshow_naga.model.City;
import com.srt.bookmyshow_naga.service.CityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cities")
public class CityController {
    private CityService cityService;
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }
    @GetMapping
    public List<City> getAllCities() {
        return cityService.findAllCities();
    }
    @PostMapping
    public List<City> addCities(@RequestBody List<City> cities) {
        return cityService.addAllCities(cities);
    }
}
