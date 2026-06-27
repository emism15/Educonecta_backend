package com.educonecta.repository;

import com.educonecta.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findByIsActiveTrue();
    Optional<Student> findByStudentIdAndIsActiveTrue(Integer studentId);
    Optional<Student> findByDni(String dni);
}