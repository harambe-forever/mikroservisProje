package com.atasoy.ticketservice.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class KafkaTicketDto {
    private TicketDto ticket;
    private EventDto event;

}
