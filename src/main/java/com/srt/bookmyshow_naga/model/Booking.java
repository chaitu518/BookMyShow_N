package com.srt.bookmyshow_naga.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // One booking is always for one show
    @ManyToOne
    @JoinColumn(name = "show_id", nullable = false)
    private Show show;

    // Seats booked in this booking (for that show)
    @ManyToMany
    @JoinTable(
            name = "booking_show_seats",
            joinColumns = @JoinColumn(name = "booking_id"),
            inverseJoinColumns = @JoinColumn(name = "show_seat_id")
    )
    private List<ShowSeat> showSeats;

    private Double totalAmount;

    private LocalDateTime bookingTime;

    @Enumerated(EnumType.STRING)
    private BookingStatus status;
}
