package com.example.doctor_service.entity;

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
@Table(name = "mjeku")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Mjeku {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mjekuid;

    @Column(name = "emri", nullable = false)
    private String emri;

    @Column(name = "mbiemri", nullable = false)
    private String mbiemri;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "numri_telefonit", nullable = false)
    private String numri_telefonit;

    @Column(name = "repartiid", nullable = false)
    private Long repartiid;
}
