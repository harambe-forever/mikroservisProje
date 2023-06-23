package com.atasoy.eventservice.mapper;

import com.atasoy.eventservice.dto.EventDto;
import com.atasoy.eventservice.entity.Event;

public class EventMapper {

    public static EventDto mapToEventDto(Event event){
        return new EventDto(
                event.getId(),
                event.getName(),
                event.getDescription(),
                event.getLocation(),
                event.getPrice(),
                event.getDate()
        );

    }

    public static Event mapToEventDto(EventDto eventDto){
        return new Event(
                eventDto.getId(),
                eventDto.getName(),
                eventDto.getDescription(),
                eventDto.getLocation(),
                eventDto.getPrice(),
                eventDto.getDate()

        );

    }
}
