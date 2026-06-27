package com.educonecta.service;


import com.educonecta.dto.PaymentRequest;
import com.educonecta.dto.PaymentResponse;
import com.educonecta.entity.Payment;
import com.educonecta.entity.Quota;
import com.educonecta.exception.ResourceNotFoundException;
import com.educonecta.repository.PaymentRepository;
import com.educonecta.repository.QuotaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final QuotaRepository quotaRepository;

    public PaymentService(
            PaymentRepository paymentRepository,
            QuotaRepository quotaRepository) {

        this.paymentRepository = paymentRepository;
        this.quotaRepository = quotaRepository;
    }

    public PaymentResponse create(
            PaymentRequest request) {

        Quota quota =
                quotaRepository.findById(
                        request.getQuotaId())
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Cuota no encontrada"));

        Payment payment =
                new Payment();

        payment.setQuota(quota);

        payment.setMontoPagado(
                request.getMontoPagado());

        payment.setFechaPago(
                LocalDate.now());

        payment.setMetodoPago(
                request.getMetodoPago());

        payment.setIsActive(true);

        payment =
                paymentRepository.save(payment);

        quota.setEstado("PAGADA");

        quotaRepository.save(quota);

        return toResponse(payment);
    }

    public List<PaymentResponse> findAll() {

        return paymentRepository.findAll()
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    private PaymentResponse toResponse(
            Payment payment) {

        PaymentResponse response =
                new PaymentResponse();

        response.setPaymentId(
                payment.getPaymentId());

        response.setAlumno(
                payment.getQuota()
                        .getEnrollment()
                        .getStudent()
                        .getNombre()
                        + " "
                        +
                        payment.getQuota()
                                .getEnrollment()
                                .getStudent()
                                .getApellido());

        response.setMontoPagado(
                payment.getMontoPagado());

        response.setFechaPago(
                payment.getFechaPago());

        response.setMetodoPago(
                payment.getMetodoPago());

        response.setEstadoCuota(
                payment.getQuota()
                        .getEstado());

        return response;
    }
}
