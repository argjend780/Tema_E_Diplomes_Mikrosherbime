package com.example.appointment_service.client;

import com.example.appointment_service.dto.PatientDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "patient-service")
public interface PatientClient {
    @GetMapping("/patients/{id}")
    PatientDTO getPatientById(@PathVariable("id") Long id);
}
