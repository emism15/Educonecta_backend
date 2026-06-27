package com.educonecta.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class StudentRequest {
    private String dni;
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private String direccion;
    private String telefono;
    private String email;
    private Integer legalGuardianId;
}