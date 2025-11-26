package com.srt.bookmyshow_naga.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true, nullable = false)
    private String seatNo;

    @ManyToOne
    @JoinColumn(name = "screen_id", nullable = false)
    private Screen screen;
    private SeatType seatType;

}
