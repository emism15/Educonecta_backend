package com.educonecta.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Quotas")
public class Quota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "QuotaId")
    private Integer quotaId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "EnrollmentId", nullable = false)
    private Enrollment enrollment;

    @Column(name = "Monto", nullable = false)
    private BigDecimal monto;

    @Column(name = "FechaVencimiento", nullable = false)
    private LocalDate fechaVencimiento;

    @Column(name = "Estado", length = 20)
    private String estado;

    @Column(name = "IsActive")
    private Boolean isActive;
}
