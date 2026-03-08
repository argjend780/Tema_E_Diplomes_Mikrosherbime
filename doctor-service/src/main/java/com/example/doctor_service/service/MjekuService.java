package com.example.doctor_service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.doctor_service.client.DepartmentClient;
import com.example.doctor_service.entity.Mjeku;
import com.example.doctor_service.repository.MjekuRepository;

@Service
public class MjekuService {

    @Autowired
    private MjekuRepository repository;

    @Autowired
    private DepartmentClient departmentClient;

    public List<Mjeku> getAll() {
        return repository.findAll();
    }

    public Optional<Mjeku> getById(Long id) {
        return repository.findById(id);
    }

    public Mjeku save(Mjeku mjeku) {
        // Validate department existence
        departmentClient.getDepartmentById(mjeku.getRepartiid());
        return repository.save(mjeku);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
