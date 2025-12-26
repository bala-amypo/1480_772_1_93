package com.example.demo.service;

import com.example.demo.model.ActiveIngredient;
import com.example.demo.model.Medication;
import com.example.demo.repository.ActiveIngredientRepository;
import com.example.demo.repository.MedicationRepository;
import com.example.demo.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CatalogServiceImpl implements CatalogService {

    @Autowired
    private ActiveIngredientRepository ingredientRepository;

    @Autowired
    private MedicationRepository medicationRepository;

    @Override
    public ActiveIngredient addIngredient(ActiveIngredient ingredient) {
        if (ingredientRepository.existsByName(ingredient.getName())) {
            throw new RuntimeException("Ingredient already exists");
        }
        return ingredientRepository.save(ingredient);
    }

    @Override
    public Medication addMedication(Medication medication) {
        return medicationRepository.save(medication);
    }
}
