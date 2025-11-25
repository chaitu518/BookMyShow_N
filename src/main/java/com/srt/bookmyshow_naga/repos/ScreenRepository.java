package com.srt.bookmyshow_naga.repos;

import com.srt.bookmyshow_naga.model.Screen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface ScreenRepository extends JpaRepository<Screen, Integer> {
}
