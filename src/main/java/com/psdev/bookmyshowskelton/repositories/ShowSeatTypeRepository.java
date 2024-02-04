package com.psdev.bookmyshowskelton.repositories;

import com.psdev.bookmyshowskelton.models.ShowSeatType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShowSeatTypeRepository extends JpaRepository<ShowSeatType, Long> {
    List<ShowSeatType> findAllByShow(Long showId);
}
