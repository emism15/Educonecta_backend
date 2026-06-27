package com.educonecta.service;

import com.educonecta.dto.StudentRequest;
import com.educonecta.dto.StudentResponse;
import com.educonecta.entity.LegalGuardian;
import com.educonecta.entity.Student;
import com.educonecta.exception.DuplicateResourceException;
import com.educonecta.exception.ResourceNotFoundException;
import com.educonecta.mapper.StudentMapper;
import com.educonecta.repository.LegalGuardianRepository;
import com.educonecta.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class StudentService {

    private final StudentRepository repo;
    private final LegalGuardianRepository legalGuardianRepo;
    private final StudentMapper mapper;

    public StudentService(StudentRepository repo, LegalGuardianRepository legalGuardianRepo, StudentMapper mapper) {
        this.repo = repo;
        this.legalGuardianRepo = legalGuardianRepo;
        this.mapper = mapper;
    }

    @Transactional(readOnly = true)
    public List<StudentResponse> listar() {
        return repo.findByIsActiveTrue().stream().map(mapper::toResponse).toList();
    }

    @Transactional(readOnly = true)
    public StudentResponse obtenerPorId(Integer id) {
        return mapper.toResponse(obtenerEntidad(id));
    }

    public StudentResponse crear(StudentRequest request) {
        LegalGuardian guardian = legalGuardianRepo.findByLegalGuardianIdAndIsActiveTrue(request.getLegalGuardianId())
                .orElseThrow(() -> new ResourceNotFoundException("Apoderado no encontrado con ID " + request.getLegalGuardianId()));

        Student existente = repo.findByDni(request.getDni()).orElse(null);
        if (existente != null && Boolean.TRUE.equals(existente.getIsActive())) {
            throw new DuplicateResourceException("Ya existe un estudiante con ese DNI");
        }
        if (existente != null) {
            existente.setNombre(request.getNombre());
            existente.setApellido(request.getApellido());
            existente.setEmail(request.getEmail());
            existente.setFechaNacimiento(request.getFechaNacimiento());
            existente.setDireccion(request.getDireccion());
            existente.setTelefono(request.getTelefono());
            existente.setLegalGuardian(guardian);
            existente.setIsActive(true);
            return mapper.toResponse(repo.save(existente));
        }

        Student s = new Student();
        s.setDni(request.getDni());
        s.setNombre(request.getNombre());
        s.setApellido(request.getApellido());
        s.setEmail(request.getEmail());
        s.setFechaNacimiento(request.getFechaNacimiento());
        s.setDireccion(request.getDireccion());
        s.setTelefono(request.getTelefono());
        s.setLegalGuardian(guardian);
        s.setFechaRegistro(LocalDateTime.now());
        s.setIsActive(true);
        return mapper.toResponse(repo.save(s));
    }

    public StudentResponse actualizar(Integer id, StudentRequest request) {
        Student actual = obtenerEntidad(id);
        LegalGuardian guardian = legalGuardianRepo.findByLegalGuardianIdAndIsActiveTrue(request.getLegalGuardianId())
                .orElseThrow(() -> new ResourceNotFoundException("Apoderado no encontrado con ID " + request.getLegalGuardianId()));

        Student otro = repo.findByDni(request.getDni()).orElse(null);
        if (otro != null && Boolean.TRUE.equals(otro.getIsActive()) && !otro.getStudentId().equals(id)) {
            throw new DuplicateResourceException("Ya existe otro estudiante con ese DNI");
        }

        actual.setDni(request.getDni());
        actual.setNombre(request.getNombre());
        actual.setApellido(request.getApellido());
        actual.setEmail(request.getEmail());
        actual.setFechaNacimiento(request.getFechaNacimiento());
        actual.setDireccion(request.getDireccion());
        actual.setTelefono(request.getTelefono());
        actual.setLegalGuardian(guardian);
        return mapper.toResponse(repo.save(actual));
    }

    public void eliminar(Integer id) {
        Student actual = obtenerEntidad(id);
        actual.setIsActive(false);
        repo.save(actual);
    }

    public Student obtenerEntidad(Integer id) {
        return repo.findByStudentIdAndIsActiveTrue(id)
                .orElseThrow(() -> new ResourceNotFoundException("Estudiante no encontrado con ID " + id));
    }
}