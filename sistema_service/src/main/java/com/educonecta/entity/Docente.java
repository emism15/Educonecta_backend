package com.educonecta.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "Docentes")
public class Docente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DocenteId")
    private Integer docenteId;

    @Column(name = "DNI", nullable = false, length = 8, unique = true)
    private String dni;

    @Column(name = "Nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "Apellido", nullable = false, length = 100)
    private String apellido;

    @Column(name = "Especialidad", length = 100)
    private String especialidad;

    @Column(name = "Telefono", length = 15)
    private String telefono;

    @Column(name = "Email", length = 100)
    private String email;

    @Column(name = "FechaContratacion")
    private LocalDateTime fechaContratacion;

    @Column(name = "IsActive")
    private Boolean isActive;
}