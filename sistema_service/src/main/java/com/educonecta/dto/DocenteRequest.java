package com.educonecta.dto;

import lombok.Data;

@Data
public class DocenteRequest {
    private String dni;
    private String nombre;
    private String apellido;
    private String especialidad;
    private String telefono;
    private String email;
}