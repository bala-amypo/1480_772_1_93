package com.example.demo.controller;

import com.example.demo.model.InteractionRule;
import com.example.demo.service.RuleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rules")
public class RuleController {

    private final RuleService ruleService;

    public RuleController(RuleService ruleService) {
        this.ruleService = ruleService;
    }

    // Add interaction rule
    @PostMapping
    public InteractionRule addRule(@RequestBody InteractionRule rule) {
        return ruleService.addRule(rule);
    }

    // Get all interaction rules
    @GetMapping
    public List<InteractionRule> getAllRules() {
        return ruleService.getAllRules();
    }
}
