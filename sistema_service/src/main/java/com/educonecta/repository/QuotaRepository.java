package com.educonecta.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educonecta.entity.Quota;

public interface QuotaRepository extends JpaRepository<Quota, Integer> {

    List<Quota> findByEnrollmentEnrollmentId(Integer enrollmentId);

    long countByEstado(String estado);
}
