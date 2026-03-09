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

import com.example.patient_service.entity.Pacienti;
import com.example.patient_service.service.PacientiService;

@RestController
@RequestMapping("/patients")
public class PacientiController {

    @Autowired
    private PacientiService service;

    @GetMapping
    public List<Pacienti> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pacienti> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Pacienti create(@RequestBody Pacienti pacienti) {
        return service.save(pacienti);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pacienti> update(@PathVariable Long id, @RequestBody Pacienti pacienti) {
        return service.getById(id)
                .map(existing -> {
                    pacienti.setPacientiid(id);
                    return ResponseEntity.ok(service.save(pacienti));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
