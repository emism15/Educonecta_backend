package com.educonecta.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "GradoSecciones")
public class GradoSeccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GradoSeccionId")
    private Integer gradoSeccionId;

    @Column(name = "Grado", nullable = false, length = 50)
    private String grado;

    @Column(name = "Seccion", nullable = false, length = 10)
    private String seccion;

    @Column(name = "AnioEscolar", nullable = false)
    private Integer anioEscolar;

    @Column(name = "Capacidad")
    private Integer capacidad;

    @Column(name = "IsActive")
    private Boolean isActive;
}