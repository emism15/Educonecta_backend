package com.educonecta.repository;

import com.educonecta.entity.Horario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface HorarioRepository extends JpaRepository<Horario, Integer> {
    List<Horario> findByIsActiveTrue();
    Optional<Horario> findByHorarioIdAndIsActiveTrue(Integer horarioId);
}