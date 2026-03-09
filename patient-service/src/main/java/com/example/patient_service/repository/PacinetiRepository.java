package com.example.patient_service.repository;

import com.example.patient_service.entity.Pacienti;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacinetiRepository extends JpaRepository<Pacienti, Long> {
}
