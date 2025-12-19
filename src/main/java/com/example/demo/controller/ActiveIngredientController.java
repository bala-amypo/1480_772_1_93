package com.example.demo.controller;

import com.example.demo.model.ActiveIngredientModel;
import com.example.demo.service.ActiveIngredientService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/catalog")
public class ActiveIngredientController {

    private final ActiveIngredientService ingredientService;

    public ActiveIngredientController(ActiveIngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @PostMapping("/ingredient")
    public ActiveIngredientModel addIngredient(@RequestBody ActiveIngredientModel ingredient) {
        return ingredientService.addIngredient(ingredient);
    }

    @GetMapping("/ingredients")
    public List<ActiveIngredientModel> getAllIngredients() {
        return ingredientService.getAllIngredients();
    }

    @GetMapping("/ingredient/{id}")
    public ActiveIngredientModel getIngredient(@PathVariable Long id) {
        return ingredientService.getIngredientById(id);
    }
}
