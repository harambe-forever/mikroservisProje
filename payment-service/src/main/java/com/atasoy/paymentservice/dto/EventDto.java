package com.atasoy.paymentservice.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EventDto {
    private String id;
    private String name;
    private String description;
    private String location;
    private double price;
    private String date;
}
