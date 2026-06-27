package com.educonecta.dto;

import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class StudentResponse {
    private Integer studentId;
    private String dni;
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private String direccion;
    private String telefono;
    private String email;
    private Integer legalGuardianId;
    private String legalGuardianNombre;
    private LocalDateTime fechaRegistro;
    private Boolean isActive;
}