package com.educonecta.repository;


import com.educonecta.entity.Payment;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PaymentRepository extends JpaRepository<Payment,Integer> {   
	

@Query("""
           SELECT COALESCE(SUM(p.montoPagado),0)
           FROM Payment p
           """)
    BigDecimal totalRecaudado();

}

