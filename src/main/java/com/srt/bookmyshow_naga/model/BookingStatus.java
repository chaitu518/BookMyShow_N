package com.srt.bookmyshow_naga.model;


public enum BookingStatus {
    CREATED,        // booking created but payment pending
    CONFIRMED,      // payment success
    CANCELLED,      // payment failed or user cancelled
    EXPIRED         // cleanup job auto-expired
}

