package com.srt.bookmyshow_naga.controller;

import com.srt.bookmyshow_naga.model.Screen;
import com.srt.bookmyshow_naga.service.ScreenService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/screens")
public class ScreenController {
    private ScreenService screenService;
    public ScreenController(ScreenService screenService) {
        this.screenService = screenService;
    }
    @GetMapping("/{id}")
    public Screen getScreen(@PathVariable int id) {
        return screenService.getScreenById(id);
    }
    @PostMapping()
    public Screen addScreen(@RequestParam(name = "theatreId") int theatreId, @RequestBody Screen screen) {
        return screenService.addScreen(screen, theatreId);
    }
}
