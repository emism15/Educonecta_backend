package com.educonecta.repository;

import com.educonecta.entity.LegalGuardian;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface LegalGuardianRepository extends JpaRepository<LegalGuardian, Integer> {
    List<LegalGuardian> findByIsActiveTrue();
    Optional<LegalGuardian> findByLegalGuardianIdAndIsActiveTrue(Integer legalGuardianId);
    Optional<LegalGuardian> findByDni(String dni);
}