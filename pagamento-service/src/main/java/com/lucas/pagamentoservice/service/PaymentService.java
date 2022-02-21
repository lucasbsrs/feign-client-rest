package com.lucas.pagamentoservice.service;

import com.lucas.pagamentoservice.domain.PaymentDTO;
import com.lucas.pagamentoservice.errors.exceptions.ObjectNotFoundException;
import com.sun.jdi.InternalException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.concurrent.Callable;

@Service
public class PaymentService {

    public PaymentDTO makePayment() {
        PaymentDTO payment = PaymentDTO
                .builder()
                .description("Payment made")
                .status("OK")
                .value(new BigDecimal(100))
                .build();

        throw new InternalException("Error 500");

//        return payment;
    }

    public Callable<String> getFoobar() throws InterruptedException {
        return () -> {
            Thread.sleep(15000); //this will cause a timeout
            return "foobar";
        };
    }
}
