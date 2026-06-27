package com.educonecta.service;

import com.educonecta.entity.AsignacionDocente;
import com.educonecta.entity.Docente;
import com.educonecta.entity.Horario;
import com.educonecta.exception.DuplicateResourceException;
import com.educonecta.exception.ResourceNotFoundException;
import com.educonecta.repository.AsignacionDocenteRepository;
import com.educonecta.repository.DocenteRepository;
import com.educonecta.repository.HorarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class AsignacionDocenteService {

    private final AsignacionDocenteRepository repo;
    private final DocenteRepository docenteRepo;
    private final HorarioRepository horarioRepo;

    public AsignacionDocenteService(AsignacionDocenteRepository repo,
                                    DocenteRepository docenteRepo,
                                    HorarioRepository horarioRepo) {
        this.repo = repo;
        this.docenteRepo = docenteRepo;
        this.horarioRepo = horarioRepo;
    }

    @Transactional(readOnly = true)
    public List<AsignacionDocente> listarTodos() {
        return repo.findAll();
    }

    @Transactional(readOnly = true)
    public List<AsignacionDocente> listarActivos() {
        return repo.findByIsActiveTrue();
    }

    @Transactional(readOnly = true)
    public AsignacionDocente obtenerPorId(Integer id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Asignación no encontrada con ID " + id));
    }

    public AsignacionDocente crear(Integer docenteId, Integer horarioId) {
        if (repo.existsByDocente_DocenteIdAndHorario_HorarioId(docenteId, horarioId)) {
            throw new DuplicateResourceException("Ya existe una asignación para ese docente y horario");
        }
        Docente docente = docenteRepo.findByDocenteIdAndIsActiveTrue(docenteId)
                .orElseThrow(() -> new ResourceNotFoundException("Docente no encontrado con ID " + docenteId));
        Horario horario = horarioRepo.findByHorarioIdAndIsActiveTrue(horarioId)
                .orElseThrow(() -> new ResourceNotFoundException("Horario no encontrado con ID " + horarioId));

        AsignacionDocente a = new AsignacionDocente();
        a.setDocente(docente);
        a.setHorario(horario);
        a.setFechaAsignacion(LocalDateTime.now());
        a.setIsActive(true);
        return repo.save(a);
    }

    public AsignacionDocente actualizar(Integer id, Integer docenteId, Integer horarioId) {
        AsignacionDocente actual = obtenerPorId(id);
        if (repo.existsByDocente_DocenteIdAndHorario_HorarioIdAndAsignacionIdNot(docenteId, horarioId, id)) {
            throw new DuplicateResourceException("Ya existe otra asignación con ese docente y horario");
        }
        Docente docente = docenteRepo.findByDocenteIdAndIsActiveTrue(docenteId)
                .orElseThrow(() -> new ResourceNotFoundException("Docente no encontrado con ID " + docenteId));
        Horario horario = horarioRepo.findByHorarioIdAndIsActiveTrue(horarioId)
                .orElseThrow(() -> new ResourceNotFoundException("Horario no encontrado con ID " + horarioId));

        actual.setDocente(docente);
        actual.setHorario(horario);
        return repo.save(actual);
    }

    public void desactivar(Integer id) {
        AsignacionDocente actual = obtenerPorId(id);
        actual.setIsActive(false);
        repo.save(actual);
    }

    public void reactivar(Integer id) {
        AsignacionDocente actual = obtenerPorId(id);
        actual.setIsActive(true);
        repo.save(actual);
    }
}