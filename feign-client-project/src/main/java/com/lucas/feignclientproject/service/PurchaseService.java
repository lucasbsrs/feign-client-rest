package com.lucas.feignclientproject.service;

import com.lucas.feignclientproject.integration.client.PaymentClient;
import com.lucas.feignclientproject.integration.dto.PaymentResponseDTO;
import feign.RetryableException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PurchaseService {

    @Autowired
    private PaymentClient client;

    public PaymentResponseDTO makePayment() {
        return client.makePayment();
    }

    public String timeout() {
        try {
            return client.timeout();
        } catch (RetryableException retryableException) {
            log.error(retryableException.getMessage());
        }
        return "";
    }

}
