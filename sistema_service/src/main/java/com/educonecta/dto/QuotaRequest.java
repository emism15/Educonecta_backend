package com.educonecta.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Data;

@Data
public class QuotaRequest {

    private Integer enrollmentId;

    private BigDecimal monto;

    private LocalDate fechaVencimiento;
}
