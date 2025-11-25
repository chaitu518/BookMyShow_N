package com.srt.bookmyshow_naga.service.Implementation;

import com.srt.bookmyshow_naga.model.Screen;
import com.srt.bookmyshow_naga.model.Theatre;
import com.srt.bookmyshow_naga.repos.ScreenRepository;
import com.srt.bookmyshow_naga.repos.TheatreRepository;
import com.srt.bookmyshow_naga.service.ScreenService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ScreenServiceImpl implements ScreenService {
    private ScreenRepository screenRepository;
    private TheatreRepository theatreRepository;
    public ScreenServiceImpl(ScreenRepository screenRepository, TheatreRepository theatreRepository) {
        this.screenRepository = screenRepository;
        this.theatreRepository = theatreRepository;
    }
    @Override
    public Screen getScreenById(int id) {
        return screenRepository.findById(id).orElseThrow(()-> new RuntimeException("No such screen with id " + id));
    }

    @Override
    public Screen addScreen(Screen screen, int theatreId) {
        Theatre theatre = theatreRepository.findById(theatreId).orElseThrow(()->new RuntimeException("Not found TheatreId: "+theatreId));
        screen.setTheatre(theatre);
        return screenRepository.save(screen);
    }
}
