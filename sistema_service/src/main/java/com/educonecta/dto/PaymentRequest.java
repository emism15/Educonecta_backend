package com.educonecta.dto;


import lombok.Data;

import java.math.BigDecimal;

@Data
public class PaymentRequest {

    private Integer quotaId;

    private BigDecimal montoPagado;

    private String metodoPago;
}
