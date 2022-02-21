package com.lucas.feignclientproject.integration.client;

import com.lucas.feignclientproject.integration.dto.PaymentResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "paymentClient", url = "${payment.client.url}")
public interface PaymentClient {

    @PostMapping("/payment")
    PaymentResponseDTO makePayment();

    @GetMapping("/payment")
    String timeout();

}
