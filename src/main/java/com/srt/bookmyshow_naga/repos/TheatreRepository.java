package com.srt.bookmyshow_naga.repos;

import com.srt.bookmyshow_naga.model.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TheatreRepository extends JpaRepository<Theatre, Integer> {

    @Query("SELECT t FROM Theatre t WHERE t.city.id = :cityId")
    List<Theatre> findBycityId(@Param("cityId") int cityId);
}
