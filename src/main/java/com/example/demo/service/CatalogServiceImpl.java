package com.example.demo.service;

import com.example.demo.model.ActiveIngredient;
import com.example.demo.model.Medication;
import com.example.demo.service.CatalogService;
import org.springframework.stereotype.Service;

@Service
public class CatalogServiceImpl implements CatalogService {

    @Override
    public ActiveIngredient addIngredient(ActiveIngredient ingredient) {
        // Minimal implementation
        return ingredient;
    }

    @Override
    public Medication addMedication(Medication medication) {
        // Minimal implementation
        return medication;
    }
}
