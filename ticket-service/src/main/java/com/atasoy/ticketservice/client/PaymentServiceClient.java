package com.atasoy.ticketservice.client;

import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "PAYMENT-SERVICE")
public interface PaymentServiceClient {

    @Retry(name = "sellTicket")
    @GetMapping("/api/payment/{name}")
    String makePayment(@PathVariable(name = "name") String eventName);

}
