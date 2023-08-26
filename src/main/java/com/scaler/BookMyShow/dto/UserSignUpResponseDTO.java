package com.scaler.BookMyShow.dto;

import com.scaler.BookMyShow.models.Ticket;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserSignUpResponseDTO {
    private Long id;
    private String name;
    private String email;
    private int responseCode;
    private String responseMessage;
    private List<Ticket> tickets; //TODO : change ticket to TicketResponseDTO
}
