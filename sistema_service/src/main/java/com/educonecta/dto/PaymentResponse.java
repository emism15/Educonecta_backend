package com.educonecta.dto;


import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class PaymentResponse {

    private Integer paymentId;

    private String alumno;

    private BigDecimal montoPagado;

    private LocalDate fechaPago;

    private String metodoPago;

    private String estadoCuota;
}
