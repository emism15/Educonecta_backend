package com.educonecta.controller;


import com.educonecta.dto.PaymentRequest;
import com.educonecta.dto.PaymentResponse;
import com.educonecta.service.PaymentService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(
            PaymentService paymentService) {

        this.paymentService = paymentService;
    }

    @PostMapping
    public PaymentResponse create(
            @RequestBody PaymentRequest request) {

        return paymentService.create(request);
    }

    @GetMapping
    public List<PaymentResponse> findAll() {

        return paymentService.findAll();
    }
}
