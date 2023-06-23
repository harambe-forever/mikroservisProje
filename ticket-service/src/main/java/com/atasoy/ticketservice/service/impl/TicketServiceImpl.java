package com.atasoy.ticketservice.service.impl;

import com.atasoy.ticketservice.client.EventServiceClient;
import com.atasoy.ticketservice.client.PaymentServiceClient;
import com.atasoy.ticketservice.dto.EventDto;
import com.atasoy.ticketservice.dto.KafkaTicketDto;
import com.atasoy.ticketservice.dto.TicketDto;
import com.atasoy.ticketservice.entity.Ticket;
import com.atasoy.ticketservice.entity.enums.TicketStatus;
import com.atasoy.ticketservice.mapper.TicketMapper;
import com.atasoy.ticketservice.repository.TicketRepository;
import com.atasoy.ticketservice.service.TicketService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;


@AllArgsConstructor
@Service
public class TicketServiceImpl implements TicketService {
    TicketRepository ticketRepository;
    EventServiceClient eventServiceClient;
    PaymentServiceClient paymentServiceClient;

    ObjectMapper mapper;
    public static final Logger LOGGER = LoggerFactory.getLogger(TicketServiceImpl.class);
    @Override
    public KafkaTicketDto sellTicket(String eventName, String email) {
        //todo event in zamaniyla localdate now i karsilastir daha gecse request iptal
        EventDto eventDto = eventServiceClient.getEventByName(eventName);

        Ticket ticket = ticketRepository.findFirstByEventNameAndStatus(eventName, TicketStatus.UNSOLD)
                .orElseThrow(() -> new RuntimeException("No tickets available"));

        try {
          JsonNode  node = mapper.readTree(email);
            email = node.get("email").asText();
        } catch (IOException e) {
            throw new RuntimeException("Invalid email format", e);
        }
        LOGGER.info("Email received: " + email);
        ticket.setEmail(email);
        ticket.setStatus(TicketStatus.SOLD);
        ticketRepository.save(ticket);

        //todo payment a senkronize call at ve donus bekle (payment garanti olucak varsayiliyor)
        String paymentMessage = paymentServiceClient.makePayment(eventName);
        LOGGER.info(paymentMessage);
        //todo kafka uzerinden email-service e call at
        KafkaTicketDto kafkaTicketDto = new KafkaTicketDto();
        kafkaTicketDto.setTicket(TicketMapper.mapToTicketDto(ticket));
        kafkaTicketDto.setEvent(eventDto);



        return kafkaTicketDto;


    }
}
