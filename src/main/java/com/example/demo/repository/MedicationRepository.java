package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.MedicationModel;

public interface MedicationRepository
        extends JpaRepository<MedicationModel, Long> {
}
