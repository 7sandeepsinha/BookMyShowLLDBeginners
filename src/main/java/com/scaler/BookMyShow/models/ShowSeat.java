package com.scaler.BookMyShow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class ShowSeat extends BaseModel {
    @ManyToOne
    private Show show;
    @Enumerated(EnumType.ORDINAL)
    private ShowSeatStatus showSeatStatus;
    @ManyToOne
    private Seat seat;
    private double price;
}
