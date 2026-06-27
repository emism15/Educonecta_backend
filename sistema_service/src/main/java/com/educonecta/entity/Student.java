package com.educonecta.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "StudentId")
    private Integer studentId;

    @Column(name = "DNI", nullable = false, length = 8, unique = true)
    private String dni;

    @Column(name = "Nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "Apellido", nullable = false, length = 100)
    private String apellido;

    @Column(name = "FechaNacimiento")
    private LocalDate fechaNacimiento;

    @Column(name = "Direccion", length = 255)
    private String direccion;

    @Column(name = "Telefono", length = 15)
    private String telefono;

    @Column(name = "Email", length = 100)
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LegalGuardianId")
    private LegalGuardian legalGuardian;

    @Column(name = "FechaRegistro")
    private LocalDateTime fechaRegistro;

    @Column(name = "IsActive")
    private Boolean isActive;
    

    @OneToMany(
        mappedBy = "student",
        cascade = CascadeType.ALL
     )
     private List<Enrollment> enrollments;

}