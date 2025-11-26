package com.srt.bookmyshow_naga.controller;

import com.srt.bookmyshow_naga.model.ShowSeat;
import com.srt.bookmyshow_naga.service.ShowSeatService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/showSeats")
public class ShowSeatController {
    private final ShowSeatService showSeatService;
    public ShowSeatController(ShowSeatService showSeatService) {
        this.showSeatService = showSeatService;
    }
    @GetMapping("/{showId}")
    public List<ShowSeat> getShowSeats(@PathVariable int showId) {
        return showSeatService.findAllShowSeats(showId);
    }
}
