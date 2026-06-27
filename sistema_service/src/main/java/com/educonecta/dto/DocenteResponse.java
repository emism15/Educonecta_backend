package com.educonecta.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class DocenteResponse {
    private Integer docenteId;
    private String dni;
    private String nombre;
    private String apellido;
    private String especialidad;
    private String telefono;
    private String email;
    private LocalDateTime fechaContratacion;
    private Boolean isActive;
}