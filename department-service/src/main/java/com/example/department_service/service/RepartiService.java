package com.example.department_service.service;

import com.example.department_service.entity.Reparti;
import com.example.department_service.repository.RepartiRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RepartiService {

    @Autowired
    private RepartiRepository repository;

    public List<Reparti> getAll() {
        return repository.findAll();
    }

    public Optional<Reparti> getById(Long id) {
        return repository.findById(id);
    }

    public Reparti save(Reparti reparti) {
        return repository.save(reparti);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
