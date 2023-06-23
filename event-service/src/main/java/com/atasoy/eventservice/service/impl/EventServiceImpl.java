package com.atasoy.eventservice.service.impl;

import com.atasoy.eventservice.dto.EventDto;
import com.atasoy.eventservice.entity.Event;
import com.atasoy.eventservice.mapper.EventMapper;
import com.atasoy.eventservice.repository.EventRepository;
import com.atasoy.eventservice.service.EventService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EventServiceImpl implements EventService {

    EventRepository eventRepository;

    @Override
    public List<EventDto> getAllEvents() {
        List<Event> eventList = eventRepository.findAll();
        return eventList.stream()
                        .map(EventMapper::mapToEventDto)
                        .collect(Collectors.toList());

    }

    @Override
    public EventDto getEventByName(String name) {
        Event event = eventRepository.findByName(name)
                .orElseThrow(() -> new NoSuchElementException("Event not found with the name: " + name));

        return EventMapper.mapToEventDto(event);
    }
}
