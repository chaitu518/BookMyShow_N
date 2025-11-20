package com.srt.bookmyshow_naga.repos;

import com.srt.bookmyshow_naga.model.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TheatreRepository extends JpaRepository<Theatre, Integer> {

    @Query("SELECT t FROM Theatre t WHERE t.city.id = :cityId")
    List<Theatre> findBycityId(@Param("cityId") int cityId);
}
