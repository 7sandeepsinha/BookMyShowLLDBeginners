package com.scaler.BookMyShow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Ticket extends BaseModel {
    @Enumerated(EnumType.ORDINAL)
    private BookingStatus bookingStatus;
    @ManyToOne
    private Show show;
    @OneToMany
    private List<Payment> payments;
    @ManyToOne
    private User user;
    @ManyToMany
    private List<ShowSeat> showSeats;
    private LocalDateTime bookedAt;
    private double amount;
}

/*
        Suppose, Ticket1 bought Seat1
                then Ticket1 was cancelled
                Ticket2 bought Seat1
                then Ticket2 was cancelled
                Ticket3 bought Seat1

                Seat1 belongs to 3 tickets, 2 cancelled and 1 active

                Ticket4 bought Seat2, Seat3, Seat4
                1 ticket can have many showSeats
 */