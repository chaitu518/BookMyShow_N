package com.srt.bookmyshow_naga.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookingRequest {
    private int showId;
    private List<Integer> showSeatIds;
    private int userId;
}
