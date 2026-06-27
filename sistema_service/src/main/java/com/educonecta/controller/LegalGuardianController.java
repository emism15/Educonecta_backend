package com.educonecta.controller;

import com.educonecta.dto.LegalGuardianRequest;
import com.educonecta.dto.LegalGuardianResponse;
import com.educonecta.service.LegalGuardianService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/apoderados")
public class LegalGuardianController {

    private final LegalGuardianService service;

    public LegalGuardianController(LegalGuardianService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<LegalGuardianResponse>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LegalGuardianResponse> obtenerPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(service.obtenerPorId(id));
    }

    @PostMapping
    public ResponseEntity<LegalGuardianResponse> crear(@RequestBody LegalGuardianRequest request) {
        return ResponseEntity.ok(service.crear(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LegalGuardianResponse> actualizar(@PathVariable Integer id,
                                                             @RequestBody LegalGuardianRequest request) {
        return ResponseEntity.ok(service.actualizar(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}