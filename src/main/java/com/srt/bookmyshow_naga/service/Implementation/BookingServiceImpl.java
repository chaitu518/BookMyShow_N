package com.srt.bookmyshow_naga.service.Implementation;

import com.srt.bookmyshow_naga.model.BookingRequest;
import com.srt.bookmyshow_naga.model.ShowSeat;
import com.srt.bookmyshow_naga.model.ShowSeatStatus;
import com.srt.bookmyshow_naga.repos.ShowSeatRepository;
import com.srt.bookmyshow_naga.service.BookingService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookingServiceImpl implements BookingService {
    private ShowSeatRepository showSeatRepository;
    public BookingServiceImpl(ShowSeatRepository showSeatRepository) {
        this.showSeatRepository = showSeatRepository;
    }

    @Transactional
    @Override
    public ShowSeatStatus BlockShowSeats(BookingRequest bookingRequest) {

        long now = System.currentTimeMillis();
        List<ShowSeat> showSeats = showSeatRepository.findAllForUpdate(bookingRequest.getShowSeatIds());
        if(showSeats.size() != bookingRequest.getShowSeatIds().size()) {
            throw new RuntimeException("No show seats found");
        }
        for (ShowSeat showSeat : showSeats) {
            if(showSeat.getShow().getId()!=bookingRequest.getShowId()){
                throw new RuntimeException("Show id mismatch");
            }
            if(showSeat.getShowSeatStatus()!=ShowSeatStatus.Available){
                throw new RuntimeException("Show seat is already Blocked");
            }

        }
        long expiryTime = now+5*60*1000;
        for(ShowSeat s: showSeats){
            s.setShowSeatStatus(ShowSeatStatus.Blocked);
            s.setLockExpiry(expiryTime);
        }
        showSeatRepository.saveAll(showSeats);
        return ShowSeatStatus.Blocked;
    }

    @Transactional
    @Override
    public ShowSeatStatus BookShowSeats(BookingRequest bookingRequest) {
        long now = System.currentTimeMillis();
        List<ShowSeat> showSeats = showSeatRepository.findAllForUpdate(bookingRequest.getShowSeatIds());
        if(showSeats.size() != bookingRequest.getShowSeatIds().size()) {
            throw new RuntimeException("No show seats found");
        }
        for (ShowSeat showSeat : showSeats) {
            if(showSeat.getShow().getId()!=bookingRequest.getShowId()){
                throw new RuntimeException("Show id mismatch");
            }
            if(showSeat.getShowSeatStatus()!=ShowSeatStatus.Blocked){
                throw new RuntimeException("Show seat is not available");
            }
            if(showSeat.getLockExpiry()==null || showSeat.getLockExpiry()<now){
                throw new RuntimeException("Show seat is expired");
            }
        }
        for(ShowSeat s: showSeats){
            s.setShowSeatStatus(ShowSeatStatus.Booked);
        }
        showSeatRepository.saveAll(showSeats);
        return ShowSeatStatus.Booked;
    }
}
