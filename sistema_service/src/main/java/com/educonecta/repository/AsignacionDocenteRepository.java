package com.educonecta.repository;

import com.educonecta.entity.AsignacionDocente;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface AsignacionDocenteRepository extends JpaRepository<AsignacionDocente, Integer> {
    List<AsignacionDocente> findByIsActiveTrue();
    Optional<AsignacionDocente> findByAsignacionIdAndIsActiveTrue(Integer asignacionId);
    boolean existsByDocente_DocenteIdAndHorario_HorarioId(Integer docenteId, Integer horarioId);
    boolean existsByDocente_DocenteIdAndHorario_HorarioIdAndAsignacionIdNot(Integer docenteId, Integer horarioId, Integer asignacionId);
}