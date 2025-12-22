package com.example.demo.controller;

import com.example.demo.model.InteractionCheckResult;
import com.example.demo.repository.InteractionCheckResultRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/interaction-results")
public class InteractionResultController {

    private final InteractionCheckResultRepository resultRepository;

    public InteractionResultController(InteractionCheckResultRepository resultRepository) {
        this.resultRepository = resultRepository;
    }

    @GetMapping("/{id}")
    public InteractionCheckResult getById(@PathVariable Long id) {
        return resultRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Result not found"));
    }

    @GetMapping
    public List<InteractionCheckResult> getAll() {
        return resultRepository.findAll();
    }
}
