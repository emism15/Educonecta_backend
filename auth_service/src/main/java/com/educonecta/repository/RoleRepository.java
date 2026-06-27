package com.educonecta.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.educonecta.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

    Optional<Role> findByNombre(String nombre);

}
