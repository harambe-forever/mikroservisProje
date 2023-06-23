package com.atasoy.ticketservice.client;

import com.atasoy.ticketservice.dto.EventDto;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "EVENT-SERVICE")
public interface EventServiceClient {
    @Retry(name = "sellTicket")
    @GetMapping("/api/events/{name}")
    EventDto getEventByName(@PathVariable String name);
}
