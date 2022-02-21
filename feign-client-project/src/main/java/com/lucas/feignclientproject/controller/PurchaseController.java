package com.lucas.feignclientproject.controller;

import com.lucas.feignclientproject.integration.dto.PaymentResponseDTO;
import com.lucas.feignclientproject.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

    @Autowired
    public PurchaseService service;

    @PostMapping
    public ResponseEntity<PaymentResponseDTO> makePayment() {
        PaymentResponseDTO payment = service.makePayment();

        return ResponseEntity.ok(payment);
    }

    @GetMapping
    public ResponseEntity<String> timeout() {
        service.timeout();

        return ResponseEntity.noContent().build();
    }

}
