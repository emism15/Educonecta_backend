package com.educonecta.controller;

import com.educonecta.entity.GradoSeccion;
import com.educonecta.service.GradoSeccionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/grado-secciones")
public class GradoSeccionController {

    private final GradoSeccionService service;

    public GradoSeccionController(GradoSeccionService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<GradoSeccion>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GradoSeccion> obtenerPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(service.obtenerPorId(id));
    }

    @PostMapping
    public ResponseEntity<GradoSeccion> crear(@RequestBody GradoSeccion g) {
        return ResponseEntity.ok(service.crear(g));
    }

    @PutMapping("/{id}")
    public ResponseEntity<GradoSeccion> actualizar(@PathVariable Integer id, @RequestBody GradoSeccion g) {
        return ResponseEntity.ok(service.actualizar(id, g));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}