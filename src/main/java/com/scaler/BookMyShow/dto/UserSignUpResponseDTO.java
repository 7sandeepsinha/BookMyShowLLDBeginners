package com.scaler.BookMyShow.dto;

import com.scaler.BookMyShow.models.Ticket;

import java.util.List;

public class UserSignUpResponseDTO {
    private Long id;
    private String name;
    private String email;
    private List<Ticket> tickets; //TODO : change ticket to TicketResponseDTO
}
