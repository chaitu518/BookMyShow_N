package com.srt.bookmyshow_naga.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Availability {
    int showId;
    int totalSeats;
    int availableSeats;
    int blockedSeats;
    int bookedSeats;
}
