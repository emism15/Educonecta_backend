package com.educonecta.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "AsignacionDocentes")
public class AsignacionDocente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AsignacionId")
    private Integer asignacionId;

    @ManyToOne(fetch = FetchType.EAGER)  // ← cambia LAZY por EAGER
    @JoinColumn(name = "DocenteId")
    private Docente docente;

    @ManyToOne(fetch = FetchType.EAGER)  // ← cambia LAZY por EAGER
    @JoinColumn(name = "HorarioId")
    private Horario horario;

    @Column(name = "FechaAsignacion")
    private LocalDateTime fechaAsignacion;

    @Column(name = "IsActive")
    private Boolean isActive;
}