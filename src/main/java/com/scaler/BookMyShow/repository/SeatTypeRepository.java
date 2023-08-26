package com.scaler.BookMyShow.repository;

import com.scaler.BookMyShow.models.SeatType;
import com.scaler.BookMyShow.models.Show;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SeatTypeRepository extends JpaRepository<SeatType, Long> {
    @Override
    Optional<SeatType> findById(Long showId);
    @Override
    SeatType save(SeatType show);
}
