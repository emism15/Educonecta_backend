package com.educonecta.mapper;

import com.educonecta.dto.StudentResponse;
import com.educonecta.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

    public StudentResponse toResponse(Student s) {
        StudentResponse r = new StudentResponse();
        r.setStudentId(s.getStudentId());
        r.setDni(s.getDni());
        r.setNombre(s.getNombre());
        r.setApellido(s.getApellido());
        r.setFechaNacimiento(s.getFechaNacimiento());
        r.setDireccion(s.getDireccion());
        r.setTelefono(s.getTelefono());
        r.setEmail(s.getEmail());
        r.setFechaRegistro(s.getFechaRegistro());
        r.setIsActive(s.getIsActive());
        if (s.getLegalGuardian() != null) {
            r.setLegalGuardianId(s.getLegalGuardian().getLegalGuardianId());
            r.setLegalGuardianNombre(
                s.getLegalGuardian().getNombre() + " " + s.getLegalGuardian().getApellido()
            );
        }
        return r;
    }
}