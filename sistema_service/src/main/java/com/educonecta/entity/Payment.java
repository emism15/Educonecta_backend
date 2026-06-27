package com.educonecta.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "Payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PaymentId")
    private Integer paymentId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "QuotaId", nullable = false)
    private Quota quota;

    @Column(name = "MontoPagado", nullable = false)
    private BigDecimal montoPagado;

    @Column(name = "FechaPago")
    private LocalDate fechaPago;

    @Column(name = "MetodoPago", length = 50)
    private String metodoPago;

    @Column(name = "IsActive")
    private Boolean isActive;
}
