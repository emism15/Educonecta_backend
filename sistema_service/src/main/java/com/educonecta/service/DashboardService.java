package com.educonecta.service;


import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.educonecta.dto.DashboardResponse;
import com.educonecta.repository.EnrollmentRepository;
import com.educonecta.repository.LegalGuardianRepository;
import com.educonecta.repository.PaymentRepository;
import com.educonecta.repository.QuotaRepository;
import com.educonecta.repository.StudentRepository;

@Service
public class DashboardService {

    private final LegalGuardianRepository guardianRepository;

    private final StudentRepository studentRepository;

    private final EnrollmentRepository enrollmentRepository;

    private final QuotaRepository quotaRepository;

    private final PaymentRepository paymentRepository;

    public DashboardService(
            LegalGuardianRepository guardianRepository,
            StudentRepository studentRepository,
            EnrollmentRepository enrollmentRepository,
            QuotaRepository quotaRepository,
            PaymentRepository paymentRepository) {

        this.guardianRepository = guardianRepository;
        this.studentRepository = studentRepository;
        this.enrollmentRepository = enrollmentRepository;
        this.quotaRepository = quotaRepository;
        this.paymentRepository = paymentRepository;
    }

    public DashboardResponse getDashboard() {

        DashboardResponse response =
                new DashboardResponse();

        response.setTotalApoderados(
                guardianRepository.count());

        response.setTotalAlumnos(
                studentRepository.count());

        response.setTotalMatriculas(
                enrollmentRepository.count());

        response.setTotalCuotas(
                quotaRepository.count());

        response.setTotalPagos(
                paymentRepository.count());

        response.setCuotasPendientes(
                quotaRepository.countByEstado(
                        "PENDIENTE"));

        response.setCuotasPagadas(
                quotaRepository.countByEstado(
                        "PAGADA"));

        BigDecimal total =
                paymentRepository.totalRecaudado();

        response.setTotalRecaudado(
                total);

        return response;
    }
}

