package com.lucas.feignclientproject.integration.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class PaymentResponseDTO {

    private String description;
    private BigDecimal value;
    private String status;

}
