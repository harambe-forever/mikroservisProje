package com.atasoy.ticketservice.dto;

import com.atasoy.ticketservice.entity.enums.TicketStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class TicketDto {

        private String id;
        private String eventName;
        private TicketStatus status;
        private String email;

    public TicketDto(String id, String eventName, TicketStatus status) {
        this.id = id;
        this.eventName = eventName;
        this.status = status;
    }
}
