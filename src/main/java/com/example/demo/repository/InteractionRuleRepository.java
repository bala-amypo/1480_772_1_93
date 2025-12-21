package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.InteractionRuleModel;
import java.util.Optional;

public interface InteractionRuleRepository
        extends JpaRepository<InteractionRuleModel, Long> {

    Optional<InteractionRuleModel>
    findByMedicationAAndMedicationB(String medicationA, String medicationB);
}


