package com.example.demo.service;

import com.example.demo.model.ActiveIngredientModel;
import com.example.demo.repository.ActiveIngredientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActiveIngredientServiceImpl implements ActiveIngredientService {

    private final ActiveIngredientRepository ingredientRepository;

    public ActiveIngredientServiceImpl(ActiveIngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public ActiveIngredientModel addIngredient(ActiveIngredientModel ingredient) {
        if (ingredientRepository.existsByName(ingredient.getName())) {
            throw new RuntimeException("Ingredient name already exists");
        }
        return ingredientRepository.save(ingredient);
    }

    @Override
    public List<ActiveIngredientModel> getAllIngredients() {
        return ingredientRepository.findAll();
    }

    @Override
    public ActiveIngredientModel getIngredientById(Long id) {
        return ingredientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ingredient not found with id: " + id));
    }
}
