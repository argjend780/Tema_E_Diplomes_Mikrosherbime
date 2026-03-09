package com.example.patient_service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.patient_service.entity.Diagnoza;
import com.example.patient_service.repository.DiagnozaRepository;

@Service
public class DiagnozaService {

    @Autowired
    private DiagnozaRepository repository;

    public List<Diagnoza> getAll() {
        return repository.findAll();
    }

    public Optional<Diagnoza> getById(Long id) {
        return repository.findById(id);
    }

    public List<Diagnoza> getByPacientiId(Long pacientiId) {
        return repository.findByPacientiPacientiid(pacientiId);
    }

    public Diagnoza save(Diagnoza diagnoza) {
        return repository.save(diagnoza);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
