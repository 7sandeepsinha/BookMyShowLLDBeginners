package com.scaler.BookMyShow.service;

import com.scaler.BookMyShow.exception.TicketNotFoundException;
import com.scaler.BookMyShow.exception.UserNotFoundException;
import com.scaler.BookMyShow.models.*;
import com.scaler.BookMyShow.repository.ShowSeatRepository;
import com.scaler.BookMyShow.repository.TicketRepository;
import com.scaler.BookMyShow.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketServiceImpl implements TicketService{

    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private ShowSeatRepository showSeatRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public Ticket bookTicket(Long userId, List<Long> showSeatIds, Long showId) {
        return null;
    }

    @Override
    public Ticket cancelTicket(Long ticketId) {
        Optional<Ticket> ticketOptional = ticketRepository.findById(ticketId);
        if(ticketOptional.isEmpty()){
            throw new TicketNotFoundException("Ticket for given ID is not found");
        }
        Ticket ticket = ticketOptional.get();
        ticket.setBookingStatus(BookingStatus.CANCELLED);
        for(ShowSeat showSeat : ticket.getShowSeats()){
            showSeat.setShowSeatStatus(ShowSeatStatus.AVAILABLE);
            showSeatRepository.save(showSeat);
        }
        ticketRepository.save(ticket);

        for(Payment p : ticket.getPayments()){
            p.getRefNo();
            //send a message to 3rd party with payment ref number for refund
        }
        return ticket;
    }

    @Override
    public Ticket transferTicket(Long ticketId, Long fromUserId, Long toUserId) {
        Optional<Ticket> ticketOptional = ticketRepository.findById(ticketId);
        if(ticketOptional.isEmpty()){
            throw new TicketNotFoundException("Ticket for given ID is not found");
        }

        Optional<User> fromUserOptional =userRepository.findById(fromUserId);
        Optional<User> toUserOptional =userRepository.findById(toUserId);

        if(fromUserOptional.isEmpty() || toUserOptional.isEmpty()) {
            throw new UserNotFoundException("User details given for ticket transfer is not found");
        }

        Ticket ticket = ticketOptional.get();
        User fromUser = fromUserOptional.get();

        List<Ticket> bookedTicketHistory = fromUser.getTickets();
        bookedTicketHistory.remove(ticket);
        userRepository.save(fromUser);

        User toUser = toUserOptional.get();
        bookedTicketHistory = toUser.getTickets();
        bookedTicketHistory.add(ticket);
        toUser = userRepository.save(toUser);

        ticket.setUser(toUser);
        return ticketRepository.save(ticket);
    }
}
