package com.educonecta.dto;

import lombok.Data;

@Data
public class LegalGuardianRequest {
    private String dni;
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private String direccion;
}