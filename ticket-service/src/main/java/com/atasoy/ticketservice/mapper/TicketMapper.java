package com.atasoy.ticketservice.mapper;

import com.atasoy.ticketservice.dto.TicketDto;
import com.atasoy.ticketservice.entity.Ticket;

public class TicketMapper {

    public static TicketDto mapToTicketDto(Ticket ticket){

        TicketDto ticketDto = new TicketDto(
                ticket.getId(),
                ticket.getEventName(),
                ticket.getStatus()

                );
        ticketDto.setEmail(ticket.getEmail());
        return ticketDto;


    }

    public static Ticket mapToTicket(TicketDto ticketDto){
        return new Ticket(
                ticketDto.getId(),
                ticketDto.getEventName(),
                ticketDto.getStatus()
        );


    }
}
