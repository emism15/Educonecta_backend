package com.educonecta.service;

import com.educonecta.dto.LegalGuardianRequest;
import com.educonecta.dto.LegalGuardianResponse;
import com.educonecta.entity.LegalGuardian;
import com.educonecta.exception.DuplicateResourceException;
import com.educonecta.exception.ResourceNotFoundException;
import com.educonecta.mapper.LegalGuardianMapper;
import com.educonecta.repository.LegalGuardianRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class LegalGuardianService {

    private final LegalGuardianRepository repo;
    private final LegalGuardianMapper mapper;

    public LegalGuardianService(LegalGuardianRepository repo, LegalGuardianMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @Transactional(readOnly = true)
    public List<LegalGuardianResponse> listar() {
        return repo.findByIsActiveTrue().stream().map(mapper::toResponse).toList();
    }

    @Transactional(readOnly = true)
    public LegalGuardianResponse obtenerPorId(Integer id) {
        return mapper.toResponse(obtenerEntidad(id));
    }

    public LegalGuardianResponse crear(LegalGuardianRequest request) {
        LegalGuardian existente = repo.findByDni(request.getDni()).orElse(null);
        if (existente != null && Boolean.TRUE.equals(existente.getIsActive())) {
            throw new DuplicateResourceException("Ya existe un apoderado con ese DNI");
        }
        if (existente != null) {
            mapper.updateEntity(existente, request);
            existente.setIsActive(true);
            return mapper.toResponse(repo.save(existente));
        }
        LegalGuardian g = mapper.toEntity(request);
        g.setFechaRegistro(LocalDateTime.now());
        g.setIsActive(true);
        return mapper.toResponse(repo.save(g));
    }

    public LegalGuardianResponse actualizar(Integer id, LegalGuardianRequest request) {
        LegalGuardian actual = obtenerEntidad(id);
        LegalGuardian otro = repo.findByDni(request.getDni()).orElse(null);
        if (otro != null && Boolean.TRUE.equals(otro.getIsActive()) && !otro.getLegalGuardianId().equals(id)) {
            throw new DuplicateResourceException("Ya existe otro apoderado con ese DNI");
        }
        mapper.updateEntity(actual, request);
        return mapper.toResponse(repo.save(actual));
    }

    public void eliminar(Integer id) {
        LegalGuardian actual = obtenerEntidad(id);
        actual.setIsActive(false);
        repo.save(actual);
    }

    public LegalGuardian obtenerEntidad(Integer id) {
        return repo.findByLegalGuardianIdAndIsActiveTrue(id)
                .orElseThrow(() -> new ResourceNotFoundException("Apoderado no encontrado con ID " + id));
    }
}