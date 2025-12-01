package com.srt.bookmyshow_naga.controller;

import com.srt.bookmyshow_naga.model.Booking;
import com.srt.bookmyshow_naga.model.BookingRequest;
import com.srt.bookmyshow_naga.model.ShowSeatStatus;
import com.srt.bookmyshow_naga.service.BookingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
    private BookingService bookingService;
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }
    @PostMapping("/block")
    public ShowSeatStatus block(@RequestBody BookingRequest bookingRequest) {
        return bookingService.BlockShowSeats(bookingRequest);
    }
    @PostMapping("/confirm")
    public Booking bookSeats(@RequestBody BookingRequest bookingRequest) {
        return bookingService.BookShowSeats(bookingRequest);
    }
}
