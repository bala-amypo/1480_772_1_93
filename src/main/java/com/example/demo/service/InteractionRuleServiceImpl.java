package com.example.demo.service;

import com.example.demo.model.InteractionRuleModel;
import com.example.demo.repository.InteractionRuleRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InteractionRuleServiceImpl implements InteractionRuleService {

    private final InteractionRuleRepository ruleRepository;

    public InteractionRuleServiceImpl(InteractionRuleRepository ruleRepository) {
        this.ruleRepository = ruleRepository;
    }

    @Override
    public InteractionRuleModel addRule(InteractionRuleModel rule) {
        // Check for existing rule between ingredientA and ingredientB
        List<InteractionRuleModel> existingRules = ruleRepository.findAll();
        for (InteractionRuleModel r : existingRules) {
            Long a = r.getIngredientA().getId();
            Long b = r.getIngredientB().getId();
            if ((a.equals(rule.getIngredientA().getId()) && b.equals(rule.getIngredientB().getId()))
                    || (a.equals(rule.getIngredientB().getId()) && b.equals(rule.getIngredientA().getId()))) {
                throw new RuntimeException("Interaction rule for this ingredient pair already exists");
            }
        }
        return ruleRepository.save(rule);
    }

    @Override
    public List<InteractionRuleModel> getAllRules() {
        return ruleRepository.findAll();
    }

    @Override
    public InteractionRuleModel getRuleById(Long id) {
        return ruleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rule not found with id: " + id));
    }
}
