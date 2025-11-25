package com.srt.bookmyshow_naga.repos;

import com.srt.bookmyshow_naga.model.Screen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface ScreenRepository extends JpaRepository<Screen, Integer> {
}
