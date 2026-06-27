package com.educonecta.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educonecta.dto.EnrollmentRequest;
import com.educonecta.dto.EnrollmentResponse;
import com.educonecta.service.EnrollmentService;


@RestController
@RequestMapping("/api/enrollments")
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    public EnrollmentController(
            EnrollmentService enrollmentService) {

        this.enrollmentService = enrollmentService;
    }

    @PostMapping
    public EnrollmentResponse create(
            @RequestBody EnrollmentRequest request) {

        return enrollmentService.create(
                request);
    }

    @GetMapping
    public List<EnrollmentResponse> findAll() {

        return enrollmentService.findAll();
    }
}
