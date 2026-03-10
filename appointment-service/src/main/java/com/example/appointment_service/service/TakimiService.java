package com.example.appointment_service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.appointment_service.client.DoctorClient;
import com.example.appointment_service.client.PatientClient;
import com.example.appointment_service.entity.Takimi;
import com.example.appointment_service.repository.TakimiRepository;

@Service
public class TakimiService {

    @Autowired
    private TakimiRepository repository;

    @Autowired
    private PatientClient patientClient;

    @Autowired
    private DoctorClient doctorClient;

    public List<Takimi> getAll() {
        return repository.findAll();
    }

    public Optional<Takimi> getById(Long id) {
        return repository.findById(id);
    }

    public Takimi save(Takimi takimi) {
        // Validate patient existence
        patientClient.getPatientById(takimi.getPacientiid());
        // Validate doctor existence
        doctorClient.getDoctorById(takimi.getMjekuid());

        return repository.save(takimi);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
