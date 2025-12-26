package com.example.demo.repository;

import com.example.demo.model.InteractionRule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InteractionRuleRepository extends JpaRepository<InteractionRule, Long> {

    // Find rules by ingredient id
    @Query("SELECT r FROM InteractionRule r WHERE r.ingredientA.id = :ingredientId OR r.ingredientB.id = :ingredientId")
    List<InteractionRule> findByIngredientId(Long ingredientId);

    // Find rule between two ingredients
    @Query("SELECT r FROM InteractionRule r WHERE r.ingredientA.id = :id1 AND r.ingredientB.id = :id2")
    Optional<InteractionRule> findRuleBetweenIngredients(Long id1, Long id2);
}
