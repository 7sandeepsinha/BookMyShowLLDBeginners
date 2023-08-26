package com.scaler.BookMyShow.repository;

import com.scaler.BookMyShow.models.Show;
import com.scaler.BookMyShow.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShowRepository extends JpaRepository<Show, Long> {
    @Override
    Optional<Show> findById(Long showId);
    @Override
    Show save(Show show);
}
