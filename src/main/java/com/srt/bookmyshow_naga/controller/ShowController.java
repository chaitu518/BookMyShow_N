package com.srt.bookmyshow_naga.controller;

import com.srt.bookmyshow_naga.model.Show;
import com.srt.bookmyshow_naga.service.ShowService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/shows")
public class ShowController {
    private ShowService showService;
    public ShowController(ShowService showService) {
        this.showService = showService;
    }
    @GetMapping("/{id}")
    public Show getShow(@PathVariable int id) {
        return showService.getShow(id);
    }
    @PostMapping
    public Show addShow(@RequestParam(name = "screenId")int screenId,@RequestParam(name = "movieId")int movieId,@RequestBody Show show) {
        return showService.addShow(show,screenId,movieId);

    }
}
