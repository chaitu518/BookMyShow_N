package com.srt.bookmyshow_naga.repos;

import com.srt.bookmyshow_naga.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Integer> {
    @Query("select s from Seat s where s.screen.id=:screenId")
    List<Seat> findByScreenId(@Param("screenId") int screenId);

}
