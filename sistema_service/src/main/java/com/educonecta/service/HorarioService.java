package com.educonecta.service;

import com.educonecta.entity.Horario;
import com.educonecta.exception.ResourceNotFoundException;
import com.educonecta.repository.HorarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class HorarioService {

    private final HorarioRepository repo;

    public HorarioService(HorarioRepository repo) {
        this.repo = repo;
    }

    @Transactional(readOnly = true)
    public List<Horario> listar() {
        return repo.findByIsActiveTrue();
    }

    @Transactional(readOnly = true)
    public Horario obtenerPorId(Integer id) {
        return repo.findByHorarioIdAndIsActiveTrue(id)
                .orElseThrow(() -> new ResourceNotFoundException("Horario no encontrado con ID " + id));
    }

    public Horario crear(Horario h) {
        h.setIsActive(true);
        return repo.save(h);
    }

    public Horario actualizar(Integer id, Horario h) {
        Horario actual = obtenerPorId(id);
        actual.setCurso(h.getCurso());
        actual.setDiaSemana(h.getDiaSemana());
        actual.setHoraInicio(h.getHoraInicio());
        actual.setHoraFin(h.getHoraFin());
        actual.setGradoSeccion(h.getGradoSeccion());
        actual.setDocente(h.getDocente());
        return repo.save(actual);
    }

    public void eliminar(Integer id) {
        Horario actual = obtenerPorId(id);
        actual.setIsActive(false);
        repo.save(actual);
    }
}