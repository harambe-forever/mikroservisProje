package com.atasoy.eventservice.service;

import com.atasoy.eventservice.dto.EventDto;

import java.util.List;

public interface EventService {

             List<EventDto> getAllEvents();

             EventDto getEventByName(String name);
}
