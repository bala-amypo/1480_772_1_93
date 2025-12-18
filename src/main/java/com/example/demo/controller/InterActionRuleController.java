package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.example.demo.model.InteractionRuleModel;
import com.example.demo.service.InteractionRuleService;

@RestController
@RequestMapping("/rules")
public class InteractionRuleController {

    private final InteractionRuleService service;

    public InteractionRuleController(
            InteractionRuleService service) {
        this.service = service;
    }

    // add rule
    @PostMapping
    public InteractionRuleModel addRule(
            @RequestBody InteractionRuleModel rule) {
        return service.saveRule(rule);
    }

    // list all rules
    @GetMapping
    public List<InteractionRuleModel> getRules() {
        return service.getAllRules();
    }

    // check interaction
    @GetMapping("/check")
    public InteractionRuleModel check(
            @RequestParam String medA,
            @RequestParam String medB) {
        return service.checkInteraction(medA, medB);
    }
}
