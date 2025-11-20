package com.srt.bookmyshow_naga.controller;

import com.srt.bookmyshow_naga.model.Theatre;
import com.srt.bookmyshow_naga.service.TheatreService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/theatres")
public class TheatreController {
    private TheatreService theatreService;
    public TheatreController(TheatreService theatreService) {
        this.theatreService = theatreService;
    }
    @PostMapping
    public List<Theatre> addAllCityTheatres(@RequestParam(name = "cityId") int cityId,@RequestBody List<Theatre> theatres) {
        return theatreService.addAllCityTheatres(cityId,theatres);
    }
    @GetMapping("/by-city/{city_id}")
    public List<Theatre> getAllTheatres(@PathVariable int city_id) {
        return theatreService.getTheatresByCityId(city_id);
    }

}
