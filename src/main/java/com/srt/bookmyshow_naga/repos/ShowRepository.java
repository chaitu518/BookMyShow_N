package com.srt.bookmyshow_naga.repos;

import com.srt.bookmyshow_naga.model.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowRepository extends JpaRepository<Show, Integer> {
}
