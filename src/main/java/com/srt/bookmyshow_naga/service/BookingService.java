package com.srt.bookmyshow_naga.service;


import com.srt.bookmyshow_naga.model.Booking;
import com.srt.bookmyshow_naga.model.BookingRequest;
import com.srt.bookmyshow_naga.model.ShowSeatStatus;

public interface BookingService {
    public ShowSeatStatus BlockShowSeats(BookingRequest bookingRequest);
    public Booking BookShowSeats(BookingRequest bookingRequest);
}
