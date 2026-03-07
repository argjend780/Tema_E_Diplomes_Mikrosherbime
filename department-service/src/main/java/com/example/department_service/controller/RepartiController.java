package com.example.department_service.controller;

import com.example.department_service.entity.Reparti;
import com.example.department_service.service.RepartiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class RepartiController {

    @Autowired
    private RepartiService service;

    @GetMapping
    public List<Reparti> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reparti> getById(@PathVariable Long id) {
        return service.getById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Reparti create(@RequestBody Reparti reparti) {
        return service.save(reparti);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reparti> update(@PathVariable Long id, @RequestBody Reparti reparti) {
        return service.getById(id)
                .map(existing -> {
                    reparti.setId(id);
                    return ResponseEntity.ok(service.save(reparti));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
