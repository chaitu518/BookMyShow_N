package com.srt.bookmyshow_naga.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "shows")
public class Show{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "screen_Id", nullable = false)
    private Screen screen;

    @ManyToOne
    @JoinColumn(name = "movie_Id", nullable = false)
    private Movie movie;

    private LocalDate startTime;

    private Double price;

}
