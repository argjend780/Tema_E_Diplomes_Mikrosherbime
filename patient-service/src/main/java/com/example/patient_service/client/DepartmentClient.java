package com.example.patient_service.client;

import com.example.patient_service.dto.DepartmentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "department-service")
public interface DepartmentClient {
    @GetMapping("/departments/{id}")
    DepartmentDTO getDepartmentById(@PathVariable("id") Long id);
}
