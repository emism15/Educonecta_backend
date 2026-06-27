package com.educonecta.entity;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor


@Table(name = "Enrollments")
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EnrollmentId")
    private Integer enrollmentId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "StudentId", nullable = false)
    private Student student;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "GradoSeccionId", nullable = false)
    private GradoSeccion gradoSeccion;

    @Column(name = "FechaMatricula")
    private LocalDate fechaMatricula;

    @Column(name = "Estado", length = 20)
    private String estado;

    @Column(name = "IsActive")
    private Boolean isActive;
}


