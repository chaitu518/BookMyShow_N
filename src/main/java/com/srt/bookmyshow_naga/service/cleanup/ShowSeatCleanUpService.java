package com.srt.bookmyshow_naga.service.cleanup;

import com.srt.bookmyshow_naga.model.ShowSeat;
import com.srt.bookmyshow_naga.model.ShowSeatStatus;
import com.srt.bookmyshow_naga.repos.ShowSeatRepository;
import jakarta.transaction.Transactional;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowSeatCleanUpService {
    private ShowSeatRepository showSeatRepository;
    public ShowSeatCleanUpService(ShowSeatRepository showSeatRepository) {
        this.showSeatRepository = showSeatRepository;
    }

    @Scheduled(fixedDelay = 60_000)
    @Transactional
    public void relEaseExpiredBlockedSeats(){
        long now = System.currentTimeMillis();

        List<ShowSeat> showSeatList = showSeatRepository.findAllByShowSeatStatusAndLockExpiryLessThan(ShowSeatStatus.Blocked,now);

        if(showSeatList.isEmpty()){
            return;
        }
        for(ShowSeat showSeat : showSeatList){
            showSeat.setShowSeatStatus(ShowSeatStatus.Available);
            showSeat.setLockExpiry(null);
        }
        showSeatRepository.saveAll(showSeatList);
    }
}
