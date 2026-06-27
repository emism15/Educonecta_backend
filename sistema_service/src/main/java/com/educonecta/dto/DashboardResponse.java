package com.educonecta.dto;


import lombok.Data;
import java.math.BigDecimal;

@Data
public class DashboardResponse {

    private Long totalApoderados;

    private Long totalAlumnos;

    private Long totalMatriculas;

    private Long totalCuotas;

    private Long totalPagos;

    private Long cuotasPendientes;

    private Long cuotasPagadas;

    private BigDecimal totalRecaudado;
}
