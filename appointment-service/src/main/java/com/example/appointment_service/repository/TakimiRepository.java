package com.example.appointment_service.repository;

import com.example.appointment_service.entity.Takimi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TakimiRepository extends JpaRepository<Takimi, Long> {
}
