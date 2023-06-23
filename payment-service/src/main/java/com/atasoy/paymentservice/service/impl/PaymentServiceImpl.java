package com.atasoy.paymentservice.service.impl;

import com.atasoy.paymentservice.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentServiceImpl.class);
    @Override
    public String makePayment() {
        try {
            // Simulate payment processing delay
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            LOGGER.info("Payment processing was interrupted", e);
        }

        return "Your payment is SUCCESSFUL!!";


    }
}
