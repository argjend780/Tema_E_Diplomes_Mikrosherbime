package com.example.patient_service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pacienti")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pacienti {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pacientiid;

    @Column(name = "emri", nullable = false)
    private String emri;

    @Column(name = "mbiemri", nullable = false)
    private String mbiemri;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "repartiid", nullable = false)
    private Long repartiid;
}
