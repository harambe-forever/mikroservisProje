package com.atasoy.ticketservice.service;

import com.atasoy.ticketservice.dto.KafkaTicketDto;
import com.atasoy.ticketservice.dto.TicketDto;

public interface TicketService {

    KafkaTicketDto sellTicket(String eventName, String email);


}
