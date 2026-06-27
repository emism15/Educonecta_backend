package com.educonecta.service;

import com.educonecta.entity.GradoSeccion;
import com.educonecta.exception.ResourceNotFoundException;
import com.educonecta.repository.GradoSeccionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GradoSeccionService {

    private final GradoSeccionRepository repo;

    public GradoSeccionService(GradoSeccionRepository repo) {
        this.repo = repo;
    }

    @Transactional(readOnly = true)
    public List<GradoSeccion> listar() {
        return repo.findByIsActiveTrue();
    }

    @Transactional(readOnly = true)
    public GradoSeccion obtenerPorId(Integer id) {
        return repo.findByGradoSeccionIdAndIsActiveTrue(id)
                .orElseThrow(() -> new ResourceNotFoundException("GradoSeccion no encontrado con ID " + id));
    }

    public GradoSeccion crear(GradoSeccion g) {
        g.setIsActive(true);
        return repo.save(g);
    }

    public GradoSeccion actualizar(Integer id, GradoSeccion g) {
        GradoSeccion actual = obtenerPorId(id);
        actual.setGrado(g.getGrado());
        actual.setSeccion(g.getSeccion());
        actual.setAnioEscolar(g.getAnioEscolar());
        actual.setCapacidad(g.getCapacidad());
        return repo.save(actual);
    }

    public void eliminar(Integer id) {
        GradoSeccion actual = obtenerPorId(id);
        actual.setIsActive(false);
        repo.save(actual);
    }
}