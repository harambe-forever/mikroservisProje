package com.atasoy.eventservice.repository;

import com.atasoy.eventservice.entity.Event;
import org.springframework.data.mongodb.repository.MongoRepository;


import java.util.Optional;

public interface EventRepository extends MongoRepository<Event, String> {

    Optional<Event> findByName(String name);
}
