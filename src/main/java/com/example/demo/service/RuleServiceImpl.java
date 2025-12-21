package com.example.demo.service.impl;

import com.example.demo.model.InteractionRule;
import com.example.demo.repository.InteractionRuleRepository;
import com.example.demo.service.RuleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RuleServiceImpl implements RuleService {

    private final InteractionRuleRepository ruleRepository;

    public RuleServiceImpl(InteractionRuleRepository ruleRepository) {
        this.ruleRepository = ruleRepository;
    }

    @Override
    public InteractionRule addRule(InteractionRule rule) {

        String severity = rule.getSeverity();
        if (!severity.equals("MINOR") &&
            !severity.equals("MODERATE") &&
            !severity.equals("MAJOR")) {
            throw new IllegalArgumentException("Invalid severity level");
        }

        Long a = rule.getIngredientA().getId();
        Long b = rule.getIngredientB().getId();

        if (ruleRepository.findByIngredientAIdAndIngredientBId(a, b).isPresent()
         || ruleRepository.findByIngredientAIdAndIngredientBId(b, a).isPresent()) {
            throw new IllegalArgumentException("Interaction rule already exists");
        }

        return ruleRepository.save(rule);
    }

    @Override
    public List<InteractionRule> getAllRules() {
        return ruleRepository.findAll();
    }
}
