package com.atasoy.eventservice.controller;

import com.atasoy.eventservice.dto.EventDto;
import com.atasoy.eventservice.service.EventService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
@AllArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EventController {
    EventService eventService;

    @GetMapping
    ResponseEntity<List<EventDto>> getAllEvents(){
        return new ResponseEntity<>(eventService.getAllEvents(), HttpStatus.OK);
    }

    @GetMapping("{name}")
    ResponseEntity<EventDto> getEventByName(@PathVariable String name){
    return  new ResponseEntity<>(eventService.getEventByName(name),HttpStatus.OK);
    }
}
