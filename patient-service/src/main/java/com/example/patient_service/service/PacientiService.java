package com.example.patient_service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.patient_service.client.DepartmentClient;
import com.example.patient_service.entity.Pacienti;
import com.example.patient_service.repository.PacinetiRepository;

@Service
public class PacientiService {

    @Autowired
    private PacinetiRepository repository;

    @Autowired
    private DepartmentClient departmentClient;

    public List<Pacienti> getAll() {
        return repository.findAll();
    }

    public Optional<Pacienti> getById(Long id) {
        return repository.findById(id);
    }

    public Pacienti save(Pacienti pacienti) {
        // Validate department existence
        departmentClient.getDepartmentById(pacienti.getRepartiid());
        return repository.save(pacienti);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
