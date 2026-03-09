package com.example.patient_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.patient_service.entity.Diagnoza;
import com.example.patient_service.service.DiagnozaService;

@RestController
@RequestMapping("/diagnoses")
public class DiagnozaController {

    @Autowired
    private DiagnozaService service;

    @GetMapping
    public List<Diagnoza> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Diagnoza> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/patient/{pacientiId}")
    public List<Diagnoza> getByPatientId(@PathVariable Long pacientiId) {
        return service.getByPacientiId(pacientiId);
    }

    @PostMapping
    public Diagnoza create(@RequestBody Diagnoza diagnoza) {
        return service.save(diagnoza);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Diagnoza> update(@PathVariable Long id, @RequestBody Diagnoza diagnoza) {
        return service.getById(id)
                .map(existing -> {
                    diagnoza.setDiagnozaid(id);
                    return ResponseEntity.ok(service.save(diagnoza));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
