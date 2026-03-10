package com.example.appointment_service.entity;

import java.time.LocalDateTime;

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
@Table(name = "takimi")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Takimi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long takimiId;

    @Column(name = "data_ora", nullable = false)
    private LocalDateTime data_ora;

    @Column(name = "arsyeja", nullable = false)
    private String arsyeja;

    @Column(name = "mjekuid", nullable = false)
    private Long mjekuid;

    @Column(name = "pacientiid", nullable = false)
    private Long pacientiid;
}
