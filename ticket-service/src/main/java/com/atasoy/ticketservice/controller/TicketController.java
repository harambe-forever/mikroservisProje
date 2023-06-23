package com.atasoy.ticketservice.controller;

import com.atasoy.ticketservice.client.EventServiceClient;
import com.atasoy.ticketservice.dto.EventDto;
import com.atasoy.ticketservice.dto.KafkaTicketDto;
import com.atasoy.ticketservice.dto.TicketDto;
import com.atasoy.ticketservice.service.TicketService;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/tickets")
@AllArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.POST, RequestMethod.OPTIONS})
public class TicketController {
    TicketService ticketService;




    @PostMapping("{event-name}")

    ResponseEntity<KafkaTicketDto> sellTicket(@PathVariable("event-name") String eventName, @RequestBody String email){

        //todo servisi calistir
        KafkaTicketDto ticketDto = ticketService.sellTicket(eventName, email);




        //todo response entity dondur
        return new ResponseEntity<>(ticketDto, HttpStatus.OK);
    }



}
