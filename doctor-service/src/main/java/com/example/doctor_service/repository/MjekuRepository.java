package com.example.doctor_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.doctor_service.entity.Mjeku;

@Repository
public interface MjekuRepository extends JpaRepository<Mjeku, Long> {
}
