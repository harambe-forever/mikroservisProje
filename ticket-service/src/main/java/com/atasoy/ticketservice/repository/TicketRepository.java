package com.atasoy.ticketservice.repository;

import com.atasoy.ticketservice.entity.Ticket;
import com.atasoy.ticketservice.entity.enums.TicketStatus;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface TicketRepository extends MongoRepository<Ticket,String> {
    Optional<Ticket> findFirstByEventNameAndStatus(String eventName, TicketStatus status);
}

