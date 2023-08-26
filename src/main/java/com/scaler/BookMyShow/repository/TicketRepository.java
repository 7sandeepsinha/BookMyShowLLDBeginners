package com.scaler.BookMyShow.repository;

import com.scaler.BookMyShow.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    @Override
    Optional<Ticket> findById(Long ticketId);
    @Override
    Ticket save(Ticket ticket);
}
