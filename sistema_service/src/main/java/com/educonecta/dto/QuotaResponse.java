package com.educonecta.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class QuotaResponse {

    private Integer quotaId;

    private String alumno;

    private BigDecimal monto;

    private LocalDate fechaVencimiento;

    private String estado;
}
