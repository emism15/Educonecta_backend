package com.educonecta.repository;

import com.educonecta.entity.Docente;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface DocenteRepository extends JpaRepository<Docente, Integer> {
    List<Docente> findByIsActiveTrue();
    Optional<Docente> findByDocenteIdAndIsActiveTrue(Integer docenteId);
    Optional<Docente> findByDni(String dni);
}