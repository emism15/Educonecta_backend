package com.educonecta.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class LegalGuardianResponse {
    private Integer legalGuardianId;
    private String dni;
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private String direccion;
    private LocalDateTime fechaRegistro;
    private Boolean isActive;
}