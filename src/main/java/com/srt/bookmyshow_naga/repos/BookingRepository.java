package com.srt.bookmyshow_naga.repos;

import com.srt.bookmyshow_naga.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
}
