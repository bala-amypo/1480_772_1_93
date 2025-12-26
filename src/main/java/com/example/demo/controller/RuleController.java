// package com.example.demo.controller;

// import com.example.demo.model.InteractionRule;
// import com.example.demo.service.RuleService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("/api/rules")
// public class RuleController {

//     @Autowired
//     private RuleService ruleService;

//     @PostMapping
//     public ResponseEntity<InteractionRule> addRule(@RequestBody InteractionRule rule) {
//         return ResponseEntity.ok(ruleService.addRule(rule));
//     }

//     @GetMapping("/{id}")
//     public ResponseEntity<InteractionRule> getRule(@PathVariable Long id) {
//         return ResponseEntity.ok(ruleService.getRule(id));
//     }
// }



package com.example.demo.controller;

import com.example.demo.model.InteractionRule;
import com.example.demo.service.RuleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rules")
@Tag(name = "Rules", description = "Manage Drug-to-Drug Interaction Rules")
public class RuleController {

    private final RuleService ruleService;

    public RuleController(RuleService ruleService) {
        this.ruleService = ruleService;
    }

    @PostMapping
    @Operation(summary = "Add a new interaction rule")
    public ResponseEntity<InteractionRule> addRule(@RequestBody InteractionRule rule) {
        return ResponseEntity.ok(ruleService.addRule(rule));
    }

    @GetMapping
    @Operation(summary = "List all interaction rules")
    public ResponseEntity<List<InteractionRule>> getAllRules() {
        return ResponseEntity.ok(ruleService.getAllRules());
    }
}