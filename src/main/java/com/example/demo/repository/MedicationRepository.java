package com.example.demo.repository;

import com.example.demo.model.MedicationModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicationRepository extends JpaRepository<MedicationModel, Long> {
    boolean existsByName(String name);
}
