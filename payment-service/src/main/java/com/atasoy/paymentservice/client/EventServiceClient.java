package com.atasoy.paymentservice.client;

import com.atasoy.paymentservice.dto.EventDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "EVENT-SERVICE")
public interface EventServiceClient {

    @GetMapping("/api/events/{name}")
    EventDto getEventByName(@PathVariable String name);
}
