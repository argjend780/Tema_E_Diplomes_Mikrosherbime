package com.example.patient_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.patient_service.entity.Diagnoza;

@Repository
public interface DiagnozaRepository extends JpaRepository<Diagnoza, Long> {
    List<Diagnoza> findByPacientiPacientiid(Long pacientiid);
}
