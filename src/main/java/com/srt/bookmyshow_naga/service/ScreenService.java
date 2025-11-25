package com.srt.bookmyshow_naga.service;

import com.srt.bookmyshow_naga.model.Screen;

import java.util.Optional;

public interface ScreenService {
    public Screen getScreenById(int id);
    public Screen addScreen(Screen screen,int theatreId);

}
