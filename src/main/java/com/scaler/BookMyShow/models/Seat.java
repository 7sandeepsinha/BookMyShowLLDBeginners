package com.scaler.BookMyShow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Seat extends BaseModel {
    private int rowVal;
    private int colVal;
    private String seatNumber;
    @ManyToOne
    private SeatType seatType;
}
// 100 seats
// VIP, Gold and Silver
// VIP seatType -> 20 seats || Seat to SeatType -> ManyToOne
// GOLD -> 50
// SILVER -> 30