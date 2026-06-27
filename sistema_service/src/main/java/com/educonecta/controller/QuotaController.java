package com.educonecta.controller;


import com.educonecta.dto.QuotaRequest;
import com.educonecta.dto.QuotaResponse;
import com.educonecta.service.QuotaService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quotas")
public class QuotaController {

    private final QuotaService quotaService;

    public QuotaController(
            QuotaService quotaService) {

        this.quotaService = quotaService;
    }

    @PostMapping
    public QuotaResponse create(
            @RequestBody QuotaRequest request) {

        return quotaService.create(request);
    }

    @GetMapping
    public List<QuotaResponse> findAll() {

        return quotaService.findAll();
    }
}
