package com.example.demo.repository;

import com.example.demo.model.InteractionRuleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface InteractionRuleRepository extends JpaRepository<InteractionRuleModel, Long> {

    // Find all rules where ingredient is involved
    List<InteractionRuleModel> findByIngredientAIdOrIngredientBId(Long ingredientIdA, Long ingredientIdB);

    // Find rule between two ingredients (A-B or B-A)
    default InteractionRuleModel findRuleBetweenIngredients(Long id1, Long id2, List<InteractionRuleModel> allRules) {
        for (InteractionRuleModel rule : allRules) {
            Long a = rule.getIngredientA().getId();
            Long b = rule.getIngredientB().getId();
            if ((a.equals(id1) && b.equals(id2)) || (a.equals(id2) && b.equals(id1))) {
                return rule;
            }
        }
        return null;
    }
}
