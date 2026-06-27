package com.educonecta.dto;

import lombok.Data;

@Data
public class EnrollmentResponse {

    private Integer enrollmentId;

    private String alumno;

    private String grado;

    private String seccion;

    private Integer anioEscolar;

    private String estado;

}
