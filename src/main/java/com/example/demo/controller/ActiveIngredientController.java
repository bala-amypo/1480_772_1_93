package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.example.demo.model.ActiveIngredientModel;
import com.example.demo.service.ActiveIngredientService;

@RestController
@RequestMapping("/ingredients")
public class ActiveIngredientController {

    private final ActiveIngredientService service;

    public ActiveIngredientController(ActiveIngredientService service) {
        this.service = service;
    }

    @PostMapping
    public ActiveIngredientModel addIngredient(
            @RequestBody ActiveIngredientModel ingredient) {
        return service.save(ingredient);
    }

    @GetMapping
    public List<ActiveIngredientModel> getAllIngredients() {
        return service.getAll();
    }
}
