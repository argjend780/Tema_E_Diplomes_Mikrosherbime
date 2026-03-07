package com.example.department_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.department_service.entity.Reparti;

@Repository
public interface RepartiRepository extends JpaRepository<Reparti, Long> {
}
