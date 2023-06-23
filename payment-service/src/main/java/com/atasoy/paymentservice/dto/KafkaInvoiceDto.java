package com.atasoy.paymentservice.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class KafkaInvoiceDto {
    private String firstName;
    private String lastName;
    private EventDto event;
}
