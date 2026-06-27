package com.educonecta.controller;

import com.educonecta.dto.AsignacionDocenteRequest;
import com.educonecta.entity.AsignacionDocente;
import com.educonecta.service.AsignacionDocenteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/asignaciones-docente")
public class AsignacionDocenteController {

    private final AsignacionDocenteService service;

    public AsignacionDocenteController(AsignacionDocenteService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<AsignacionDocente>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/activos")
    public ResponseEntity<List<AsignacionDocente>> listarActivos() {
        return ResponseEntity.ok(service.listarActivos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AsignacionDocente> obtenerPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(service.obtenerPorId(id));
    }

    @PostMapping
    public ResponseEntity<AsignacionDocente> crear(@RequestBody AsignacionDocenteRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.crear(request.getDocenteId(), request.getHorarioId()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AsignacionDocente> actualizar(@PathVariable Integer id,
                                                         @RequestBody AsignacionDocenteRequest request) {
        return ResponseEntity.ok(service.actualizar(id, request.getDocenteId(), request.getHorarioId()));
    }

    @PatchMapping("/{id}/desactivar")
    public ResponseEntity<Void> desactivar(@PathVariable Integer id) {
        service.desactivar(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/reactivar")
    public ResponseEntity<Void> reactivar(@PathVariable Integer id) {
        service.reactivar(id);
        return ResponseEntity.noContent().build();
    }
}