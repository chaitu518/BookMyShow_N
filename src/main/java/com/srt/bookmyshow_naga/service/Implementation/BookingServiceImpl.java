package com.srt.bookmyshow_naga.service.Implementation;

import com.srt.bookmyshow_naga.model.*;
import com.srt.bookmyshow_naga.model.dto.BookingRequest;
import com.srt.bookmyshow_naga.repos.BookingRepository;
import com.srt.bookmyshow_naga.repos.ShowSeatRepository;
import com.srt.bookmyshow_naga.repos.UserRepository;
import com.srt.bookmyshow_naga.service.BookingService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class BookingServiceImpl implements BookingService {
    private ShowSeatRepository showSeatRepository;
    private BookingRepository bookingRepository;
    private UserRepository userRepository;
    public BookingServiceImpl(ShowSeatRepository showSeatRepository, BookingRepository bookingRepository,UserRepository userRepository) {
        this.showSeatRepository = showSeatRepository;
        this.bookingRepository = bookingRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    @Override
    public ShowSeatStatus BlockShowSeats(BookingRequest bookingRequest) {

        long now = System.currentTimeMillis();
        List<ShowSeat> showSeats = showSeatRepository.findAllForUpdate(bookingRequest.getShowSeatIds());
        User user = (User) userRepository.findById(bookingRequest.getUserId()).orElseThrow(()->new RuntimeException("user with userId : "+bookingRequest.getUserId()+" not found."));
        if(showSeats.size() != bookingRequest.getShowSeatIds().size()) {
            throw new RuntimeException("No show seats found");
        }
        for (ShowSeat showSeat : showSeats) {
            if(showSeat.getShow().getId()!=bookingRequest.getShowId()){
                throw new RuntimeException("Show id mismatch");
            }
            if(showSeat.getShowSeatStatus()!=ShowSeatStatus.Available){
                throw new RuntimeException("Show seat is not available");
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
    public Booking BookShowSeats(BookingRequest bookingRequest) {
        long now = System.currentTimeMillis();
        List<ShowSeat> showSeats = showSeatRepository.findAllForUpdate(bookingRequest.getShowSeatIds());
        User user = (User) userRepository.findById(bookingRequest.getUserId()).orElseThrow(()->new RuntimeException("user with userId : "+bookingRequest.getUserId()+" not found."));
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
        double totalPrice = showSeats.stream().mapToDouble(ss->ss.getPrice()!=null?ss.getPrice():0.0).sum();
        showSeatRepository.saveAll(showSeats);
        Booking booking = new Booking();
        booking.setShowSeats(showSeats);
        booking.setShow(showSeats.get(0).getShow());
        booking.setBookingTime(LocalDateTime.now());
        booking.setTotalAmount(totalPrice);
        booking.setStatus(BookingStatus.CONFIRMED);
        booking.setUser(user);
        booking = bookingRepository.save(booking);
        return booking;
    }

    @Override
    public Booking findBookingByBookingId(int bookingId) {
        return bookingRepository.findById(bookingId).orElseThrow(()->new RuntimeException("Booking not found"));
    }
}
