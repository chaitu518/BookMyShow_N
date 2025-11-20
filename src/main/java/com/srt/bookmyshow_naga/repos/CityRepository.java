package com.srt.bookmyshow_naga.repos;

import com.srt.bookmyshow_naga.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {
}
