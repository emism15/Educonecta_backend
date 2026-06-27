package com.educonecta.service;


import com.educonecta.dto.QuotaRequest;
import com.educonecta.dto.QuotaResponse;
import com.educonecta.entity.Enrollment;
import com.educonecta.entity.Quota;
import com.educonecta.exception.ResourceNotFoundException;
import com.educonecta.repository.EnrollmentRepository;
import com.educonecta.repository.QuotaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuotaService {

    private final QuotaRepository quotaRepository;
    private final EnrollmentRepository enrollmentRepository;

    public QuotaService(
            QuotaRepository quotaRepository,
            EnrollmentRepository enrollmentRepository) {

        this.quotaRepository = quotaRepository;
        this.enrollmentRepository = enrollmentRepository;
    }

    public QuotaResponse create(
            QuotaRequest request) {

        Enrollment enrollment =
                enrollmentRepository.findById(
                        request.getEnrollmentId())
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Matricula no encontrada"));

        Quota quota = new Quota();

        quota.setEnrollment(enrollment);

        quota.setMonto(
                request.getMonto());

        quota.setFechaVencimiento(
                request.getFechaVencimiento());

        quota.setEstado("PENDIENTE");

        quota.setIsActive(true);

        quota = quotaRepository.save(quota);

        return toResponse(quota);
    }

    public List<QuotaResponse> findAll() {

        return quotaRepository.findAll()
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    private QuotaResponse toResponse(
            Quota quota) {

        QuotaResponse response =
                new QuotaResponse();

        response.setQuotaId(
                quota.getQuotaId());

        response.setAlumno(
                quota.getEnrollment()
                        .getStudent()
                        .getNombre()
                        + " "
                        + quota.getEnrollment()
                        .getStudent()
                        .getApellido());

        response.setMonto(
                quota.getMonto());

        response.setFechaVencimiento(
                quota.getFechaVencimiento());

        response.setEstado(
                quota.getEstado());

        return response;
    }
}

