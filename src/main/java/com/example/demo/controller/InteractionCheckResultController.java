package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.example.demo.model.InteractionCheckResultModel;
import com.example.demo.service.InteractionCheckResultService;

@RestController
@RequestMapping("/interact")
public class InteractionCheckResultController {

    private final InteractionCheckResultService service;

    public InteractionCheckResultController(
            InteractionCheckResultService service) {
        this.service = service;
    }

    // save interaction result
    @PostMapping("/check")
    public InteractionCheckResultModel check(
            @RequestBody InteractionCheckResultModel result) {
        return service.saveResult(result);
    }

    // get all previous results
    @GetMapping("/results")
    public List<InteractionCheckResultModel> results() {
        return service.getAllResults();
    }

    // get result by id
    @GetMapping("/result/{id}")
    public InteractionCheckResultModel resultById(
            @PathVariable Long id) {
        return service.getResultById(id);
    }
}

