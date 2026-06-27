package com.educonecta.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "LegalGuardians")
public class LegalGuardian {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LegalGuardianId")
    private Integer legalGuardianId;

    @Column(name = "DNI", nullable = false, length = 8, unique = true)
    private String dni;

    @Column(name = "Nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "Apellido", nullable = false, length = 100)
    private String apellido;

    @Column(name = "Telefono", length = 15)
    private String telefono;

    @Column(name = "Email", length = 100)
    private String email;

    @Column(name = "Direccion", length = 255)
    private String direccion;

    @Column(name = "FechaRegistro")
    private LocalDateTime fechaRegistro;

    @Column(name = "IsActive")
    private Boolean isActive;
    

    @OneToMany(
        mappedBy = "legalGuardian",
        cascade = CascadeType.ALL
    )
    private List<Student> students;

}