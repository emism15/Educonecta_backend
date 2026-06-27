package com.educonecta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educonecta.entity.Enrollment;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Integer> {

}

