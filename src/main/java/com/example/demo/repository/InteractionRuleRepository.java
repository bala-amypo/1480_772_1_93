package com.example.demo.repository;

import com.example.demo.model.InteractionRuleModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InteractionRuleRepository
        extends JpaRepository<InteractionRuleModel, Long> {

    //MUST match entity field names
    Optional<InteractionRuleModel> findByIngredientA_IdAndIngredientB_Id(
            Long ingredientAId,
            Long ingredientBId
    );
}
