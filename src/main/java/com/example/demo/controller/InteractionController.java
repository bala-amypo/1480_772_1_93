package com.example.demo.controller;

import com.example.demo.model.InteractionCheckResult;
import com.example.demo.service.InteractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/interactions")
public class InteractionController {

    @Autowired
    private InteractionService interactionService;

    @PostMapping("/check")
    public ResponseEntity<InteractionCheckResult> checkInteractions(@RequestBody List<Long> medicationIds) {
        InteractionCheckResult result = interactionService.checkInteractions(medicationIds);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InteractionCheckResult> getResult(@PathVariable Long id) {
        return ResponseEntity.ok(interactionService.getResult(id));
    }
}
