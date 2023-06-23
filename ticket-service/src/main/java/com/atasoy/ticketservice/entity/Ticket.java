package com.atasoy.ticketservice.entity;


import com.atasoy.ticketservice.entity.enums.TicketStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tickets")

@Getter
@Setter
@NoArgsConstructor
public class Ticket {
    @Id
    private String id;
    @Indexed
    private String eventName;
    @Indexed
    private TicketStatus status;
    private String email;

    public Ticket(String id, String eventName, TicketStatus status) {
        this.id = id;
        this.eventName = eventName;
        this.status = status;
    }
}
