package com.srt.bookmyshow_naga.repos;

import com.srt.bookmyshow_naga.model.ShowSeat;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat, Integer> {

    List<ShowSeat> findByShowId(int showId);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("select ss from ShowSeat ss where ss.id in :ids")
    List<ShowSeat> findAllForUpdate(@Param("ids") List<Integer> showIds);

}
