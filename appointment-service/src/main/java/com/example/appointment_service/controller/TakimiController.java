package com.example.appointment_service.controller;

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

import com.example.appointment_service.entity.Takimi;
import com.example.appointment_service.service.TakimiService;

@RestController
@RequestMapping("/appointments")
public class TakimiController {

    @Autowired
    private TakimiService service;

    @GetMapping
    public List<Takimi> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Takimi> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Takimi create(@RequestBody Takimi takimi) {
        return service.save(takimi);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Takimi> update(@PathVariable Long id, @RequestBody Takimi takimi) {
        return service.getById(id)
                .map(existing -> {
                    takimi.setTakimiId(id);
                    return ResponseEntity.ok(service.save(takimi));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
