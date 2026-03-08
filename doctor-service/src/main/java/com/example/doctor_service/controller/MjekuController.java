package com.example.doctor_service.controller;

import com.example.doctor_service.entity.Mjeku;
import com.example.doctor_service.service.MjekuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors")
public class MjekuController {

    @Autowired
    private MjekuService service;

    @GetMapping
    public List<Mjeku> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mjeku> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Mjeku create(@RequestBody Mjeku mjeku) {
        return service.save(mjeku);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mjeku> update(@PathVariable Long id, @RequestBody Mjeku mjeku) {
        return service.getById(id)
                .map(existing -> {
                    mjeku.setMjekuid(id);
                    return ResponseEntity.ok(service.save(mjeku));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
