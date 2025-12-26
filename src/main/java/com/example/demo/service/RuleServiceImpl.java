package com.example.demo.service;

import com.example.demo.model.InteractionRule;
import com.example.demo.repository.InteractionRuleRepository;
import com.example.demo.service.RuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RuleServiceImpl implements RuleService {

    @Autowired
    private InteractionRuleRepository ruleRepository;

    @Override
    public InteractionRule addRule(InteractionRule rule) {
        return ruleRepository.save(rule);
    }

    @Override
    public InteractionRule getRule(Long id) {  // ✅ fix
        return ruleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rule not found"));
    }
}
