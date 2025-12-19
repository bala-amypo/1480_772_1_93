package com.example.demo.controller;

import com.example.demo.model.InteractionRuleModel;
import com.example.demo.service.InteractionRuleService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/rules")
public class InteractionRuleController {

    private final InteractionRuleService ruleService;

    public InteractionRuleController(InteractionRuleService ruleService) {
        this.ruleService = ruleService;
    }

    // Add a new interaction rule
    @PostMapping("/")
    public InteractionRuleModel addRule(@RequestBody InteractionRuleModel rule) {
        return ruleService.addRule(rule);
    }

    // Get all interaction rules
    @GetMapping("/")
    public List<InteractionRuleModel> getAllRules() {
        return ruleService.getAllRules();
    }

    // Get a single rule by ID
    @GetMapping("/{id}")
    public InteractionRuleModel getRuleById(@PathVariable Long id) {
        return ruleService.getRuleById(id);
    }
}
