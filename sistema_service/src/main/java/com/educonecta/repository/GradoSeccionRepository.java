package com.educonecta.repository;

import com.educonecta.entity.GradoSeccion;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface GradoSeccionRepository extends JpaRepository<GradoSeccion, Integer> {
    List<GradoSeccion> findByIsActiveTrue();
    Optional<GradoSeccion> findByGradoSeccionIdAndIsActiveTrue(Integer gradoSeccionId);
}