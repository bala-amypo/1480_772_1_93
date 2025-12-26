package com.example.demo.service;

import com.example.demo.model.InteractionRule;
import com.example.demo.service.RuleService;
import org.springframework.stereotype.Service;

@Service
public class RuleServiceImpl implements RuleService {

    @Override
    public InteractionRule addRule(InteractionRule rule) {
        // Minimal implementation
        return rule;
    }
}
