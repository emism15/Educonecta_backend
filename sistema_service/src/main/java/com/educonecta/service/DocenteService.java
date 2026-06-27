package com.educonecta.service;

import com.educonecta.dto.DocenteRequest;
import com.educonecta.dto.DocenteResponse;
import com.educonecta.entity.Docente;
import com.educonecta.exception.DuplicateResourceException;
import com.educonecta.exception.ResourceNotFoundException;
import com.educonecta.mapper.DocenteMapper;
import com.educonecta.repository.DocenteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class DocenteService {

    private final DocenteRepository repo;
    private final DocenteMapper mapper;

    public DocenteService(DocenteRepository repo, DocenteMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @Transactional(readOnly = true)
    public List<DocenteResponse> listar() {
        return repo.findByIsActiveTrue().stream().map(mapper::toResponse).toList();
    }

    @Transactional(readOnly = true)
    public DocenteResponse obtenerPorId(Integer id) {
        return mapper.toResponse(obtenerEntidad(id));
    }

    public DocenteResponse crear(DocenteRequest request) {
        Docente existente = repo.findByDni(request.getDni()).orElse(null);
        if (existente != null && Boolean.TRUE.equals(existente.getIsActive())) {
            throw new DuplicateResourceException("Ya existe un docente con ese DNI");
        }
        if (existente != null) {
            mapper.updateEntity(existente, request);
            existente.setIsActive(true);
            return mapper.toResponse(repo.save(existente));
        }
        Docente d = mapper.toEntity(request);
        d.setFechaContratacion(LocalDateTime.now());
        d.setIsActive(true);
        return mapper.toResponse(repo.save(d));
    }

    public DocenteResponse actualizar(Integer id, DocenteRequest request) {
        Docente actual = obtenerEntidad(id);
        Docente otro = repo.findByDni(request.getDni()).orElse(null);
        if (otro != null && Boolean.TRUE.equals(otro.getIsActive()) && !otro.getDocenteId().equals(id)) {
            throw new DuplicateResourceException("Ya existe otro docente con ese DNI");
        }
        mapper.updateEntity(actual, request);
        return mapper.toResponse(repo.save(actual));
    }

    public void eliminar(Integer id) {
        Docente actual = obtenerEntidad(id);
        actual.setIsActive(false);
        repo.save(actual);
    }

    public Docente obtenerEntidad(Integer id) {
        return repo.findByDocenteIdAndIsActiveTrue(id)
                .orElseThrow(() -> new ResourceNotFoundException("Docente no encontrado con ID " + id));
    }
}