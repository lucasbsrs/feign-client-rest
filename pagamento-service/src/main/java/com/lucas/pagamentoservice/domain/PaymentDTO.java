package com.lucas.pagamentoservice.domain;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class PaymentDTO {

    private String description;
    private BigDecimal value;
    private String status;

}
