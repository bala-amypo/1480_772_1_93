package com.example.demo.controller;

import com.example.demo.model.InteractionRule;
import com.example.demo.service.RuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rules")
public class RuleController {

    @Autowired
    private RuleService ruleService;

    @PostMapping
    public ResponseEntity<InteractionRule> addRule(@RequestBody InteractionRule rule) {
        return ResponseEntity.ok(ruleService.addRule(rule));
    }

    @GetMapping("/{id}")
    public ResponseEntity<InteractionRule> getRule(@PathVariable Long id) {
        return ResponseEntity.ok(ruleService.getRule(id));
    }
}
