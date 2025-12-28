

// package com.example.demo.service.impl;

// import com.example.demo.model.InteractionRule;
// import com.example.demo.repository.InteractionRuleRepository;
// import com.example.demo.service.RuleService;
// import org.springframework.stereotype.Service;
// import java.util.List;

// @Service
// public class RuleServiceImpl implements RuleService {
//     private InteractionRuleRepository ruleRepository;

//     // MANDATORY: Add this to pass Test Case line 252
//     public RuleServiceImpl() {}

//     public RuleServiceImpl(InteractionRuleRepository ruleRepository) {
//         this.ruleRepository = ruleRepository;
//     }

//     @Override
//     public InteractionRule addRule(InteractionRule rule) {
//         return ruleRepository.save(rule);
//     }

//     @Override
//     public List<InteractionRule> getAllRules() {
//         return ruleRepository.findAll();
//     }
// }



package com.example.demo.service.impl;

import com.example.demo.model.InteractionRule;
import com.example.demo.repository.InteractionRuleRepository;
import com.example.demo.service.RuleService;
import org.springframework.beans.factory.annotation.Autowired; // Added this import
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RuleServiceImpl implements RuleService {
    
    private InteractionRuleRepository ruleRepository;

    /**
     * MANDATORY: Keep this to pass Test Case line 252.
     * Note: This constructor is used by your test suite, but not by Spring during runtime.
     */
    public RuleServiceImpl() {
    }

    /**
     * This constructor is used by Spring to inject the repository.
     * The @Autowired annotation is REQUIRED because there are two constructors.
     */
    @Autowired
    public RuleServiceImpl(InteractionRuleRepository ruleRepository) {
        this.ruleRepository = ruleRepository;
    }

    @Override
    public InteractionRule addRule(InteractionRule rule) {
        // Validation to prevent saving null rules or handling null repository gracefully
        if (ruleRepository == null) {
            throw new IllegalStateException("InteractionRuleRepository is null. Ensure @Autowired is working.");
        }
        return ruleRepository.save(rule);
    }

    @Override
    public List<InteractionRule> getAllRules() {
        if (ruleRepository == null) {
            throw new IllegalStateException("InteractionRuleRepository is null.");
        }
        return ruleRepository.findAll();
    }
}