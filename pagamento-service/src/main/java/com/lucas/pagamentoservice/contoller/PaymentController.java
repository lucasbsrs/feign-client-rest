package com.lucas.pagamentoservice.contoller;

import com.lucas.pagamentoservice.domain.PaymentDTO;
import com.lucas.pagamentoservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService service;

    @PostMapping
    public ResponseEntity<PaymentDTO> makePayment() throws InterruptedException {
        PaymentDTO payment = service.makePayment();

        return ResponseEntity.ok(payment);
    }

    @GetMapping
    public Callable<String> timeout() throws InterruptedException {
        return service.getFoobar();
    }
}
