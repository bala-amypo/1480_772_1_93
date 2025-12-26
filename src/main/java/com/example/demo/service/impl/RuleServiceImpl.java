// package com.example.demo.service.impl;

// import com.example.demo.model.InteractionRule;
// import com.example.demo.repository.InteractionRuleRepository;
// import com.example.demo.service.RuleService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// @Service
// public class RuleServiceImpl implements RuleService {

//     @Autowired
//     private InteractionRuleRepository ruleRepository;

//     @Override
//     public InteractionRule addRule(InteractionRule rule) {
//         return ruleRepository.save(rule);
//     }

//     @Override
//     public InteractionRule getRule(Long id) {  // ✅ fix
//         return ruleRepository.findById(id)
//                 .orElseThrow(() -> new RuntimeException("Rule not found"));
//     }
// }


package com.example.demo.service.impl;

import com.example.demo.model.InteractionRule;
import com.example.demo.repository.InteractionRuleRepository;
import com.example.demo.service.RuleService;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;

@Service
public class RuleServiceImpl implements RuleService {
    private final InteractionRuleRepository ruleRepository;

    public RuleServiceImpl(InteractionRuleRepository ruleRepository) {
        this.ruleRepository = ruleRepository;
    }

    @Override
    public InteractionRule addRule(InteractionRule rule) {
        // Enforce severity constraint (Rule 6.3)
        List<String> validSeverities = Arrays.asList("MINOR", "MODERATE", "MAJOR");
        if (!validSeverities.contains(rule.getSeverity())) {
            throw new IllegalArgumentException("Invalid severity level");
        }

        // Check for existing unordered pair (Rule 6.3)
        if (ruleRepository.findRuleBetweenIngredients(
                rule.getIngredientA().getId(), 
                rule.getIngredientB().getId()).isPresent()) {
            throw new IllegalArgumentException("Interaction rule already exists for this pair");
        }

        return ruleRepository.save(rule);
    }

    @Override
    public List<InteractionRule> getAllRules() {
        return ruleRepository.findAll();
    }
}