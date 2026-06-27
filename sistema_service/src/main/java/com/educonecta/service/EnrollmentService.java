package com.educonecta.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.educonecta.dto.EnrollmentRequest;
import com.educonecta.dto.EnrollmentResponse;
import com.educonecta.entity.Enrollment;
import com.educonecta.entity.GradoSeccion;
import com.educonecta.entity.Student;
import com.educonecta.exception.ResourceNotFoundException;
import com.educonecta.repository.EnrollmentRepository;
import com.educonecta.repository.GradoSeccionRepository;
import com.educonecta.repository.StudentRepository;


@Service
public class EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;
    private final StudentRepository studentRepository;
    private final GradoSeccionRepository gradoSeccionRepository;

    public EnrollmentService(
            EnrollmentRepository enrollmentRepository,
            StudentRepository studentRepository,
            GradoSeccionRepository gradoSeccionRepository) {

        this.enrollmentRepository = enrollmentRepository;
        this.studentRepository = studentRepository;
        this.gradoSeccionRepository = gradoSeccionRepository;
    }

    public EnrollmentResponse create(
            EnrollmentRequest request) {

        Student student =
                studentRepository.findById(
                        request.getStudentId())
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Alumno no encontrado"));

        GradoSeccion gradoSeccion =
                gradoSeccionRepository.findById(
                        request.getGradoSeccionId())
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Grado/Sección no encontrado"));

        Enrollment enrollment =
                new Enrollment();

        enrollment.setStudent(student);

        enrollment.setGradoSeccion(
                gradoSeccion);

        enrollment.setFechaMatricula(
                LocalDate.now());

        enrollment.setEstado(
                "APROBADA");

        enrollment.setIsActive(true);

        enrollment =
                enrollmentRepository.save(
                        enrollment);

        EnrollmentResponse response =
                new EnrollmentResponse();

        response.setEnrollmentId(
                enrollment.getEnrollmentId());

        response.setAlumno(
                student.getNombre() + " "
                        + student.getApellido());

        response.setGrado(
                gradoSeccion.getGrado());

        response.setSeccion(
                gradoSeccion.getSeccion());

        response.setAnioEscolar(
                gradoSeccion.getAnioEscolar());

        response.setEstado(
                enrollment.getEstado());

        return response;
    }

    public List<EnrollmentResponse> findAll() {

        return enrollmentRepository.findAll()
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    private EnrollmentResponse toResponse(
            Enrollment enrollment) {

        EnrollmentResponse response =
                new EnrollmentResponse();

        response.setEnrollmentId(
                enrollment.getEnrollmentId());

        response.setAlumno(
                enrollment.getStudent().getNombre()
                        + " "
                        + enrollment.getStudent().getApellido());

        response.setGrado(
                enrollment.getGradoSeccion().getGrado());

        response.setSeccion(
                enrollment.getGradoSeccion().getSeccion());

        response.setAnioEscolar(
                enrollment.getGradoSeccion().getAnioEscolar());

        response.setEstado(
                enrollment.getEstado());

        return response;
    }
}
