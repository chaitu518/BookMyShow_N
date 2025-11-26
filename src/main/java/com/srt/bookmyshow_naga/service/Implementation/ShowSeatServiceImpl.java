package com.srt.bookmyshow_naga.service.Implementation;

import com.srt.bookmyshow_naga.model.ShowSeat;
import com.srt.bookmyshow_naga.repos.ShowSeatRepository;
import com.srt.bookmyshow_naga.service.ShowSeatService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowSeatServiceImpl implements ShowSeatService {
    private ShowSeatRepository showSeatRepository;
    public ShowSeatServiceImpl(ShowSeatRepository showSeatRepository) {
        this.showSeatRepository = showSeatRepository;
    }
    public List<ShowSeat> findAllShowSeats(int showId) {
        return showSeatRepository.findByShowId(showId);
    }
}
