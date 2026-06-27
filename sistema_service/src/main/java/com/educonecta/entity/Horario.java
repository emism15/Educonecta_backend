package com.educonecta.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalTime;

@Data
@Entity
@Table(name = "Horarios")
public class Horario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "HorarioId")
    private Integer horarioId;

    @ManyToOne(fetch = FetchType.EAGER)  // ← cambia LAZY por EAGER
    @JoinColumn(name = "GradoSeccionId")
    private GradoSeccion gradoSeccion;

    @ManyToOne(fetch = FetchType.EAGER)  // ← cambia LAZY por EAGER
    @JoinColumn(name = "DocenteId")
    private Docente docente;

    @Column(name = "Curso", nullable = false, length = 100)
    private String curso;

    @Column(name = "DiaSemana", nullable = false, length = 20)
    private String diaSemana;

    @Column(name = "HoraInicio")
    private LocalTime horaInicio;

    @Column(name = "HoraFin")
    private LocalTime horaFin;

    @Column(name = "IsActive")
    private Boolean isActive;
}
