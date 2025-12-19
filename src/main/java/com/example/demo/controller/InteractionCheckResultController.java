package com.example.demo.controller;

import com.example.demo.model.InteractionCheckResultModel;
import com.example.demo.service.InteractionCheckResultService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/interact/result")
public class InteractionCheckResultController {

    private final InteractionCheckResultService resultService;

    public InteractionCheckResultController(InteractionCheckResultService resultService) {
        this.resultService = resultService;
    }

    // GET /interact/result/{id} → retrieve a previous interaction check
    @GetMapping("/{id}")
    public InteractionCheckResultModel getResult(@PathVariable Long id) {
        return resultService.getResultById(id);
    }
}
