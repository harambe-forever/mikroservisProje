package com.atasoy.paymentservice.controller;

import com.atasoy.paymentservice.client.EventServiceClient;
import com.atasoy.paymentservice.dto.KafkaInvoiceDto;
import com.atasoy.paymentservice.service.PaymentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payment")
@AllArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PaymentController {
    PaymentService paymentService;
    EventServiceClient eventServiceClient;
    ObjectMapper mapper;

    public static final Logger LOGGER = LoggerFactory.getLogger(PaymentController.class);

    @GetMapping("/{name}")
    ResponseEntity<KafkaInvoiceDto> makePayment(@PathVariable(name = "name") String eventName){
        //todo bu methodu ticketService cagiracak
        //todo cagirinca servis calisacak (mesaj local variablda tutulacak)
        String payment = paymentService.makePayment();
        //todo  sonra kafkaya dummy invoice infosu yollanicak
        KafkaInvoiceDto kafkaInvoiceDto = new KafkaInvoiceDto();
        kafkaInvoiceDto.setFirstName("Anil");
        kafkaInvoiceDto.setLastName("Atasoy");
        //todo burdaki datayi eventten al



        kafkaInvoiceDto.setEvent(eventServiceClient.getEventByName(eventName));



        // en sonda response entityde ok ve tutulan local variable daki success mesaji dondurulecek
        return new ResponseEntity<>( kafkaInvoiceDto,HttpStatus.OK);
    }

}
