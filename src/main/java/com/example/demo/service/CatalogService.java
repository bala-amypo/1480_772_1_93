package com.example.demo.service;

import com.example.demo.model.Medication;
import com.example.demo.model.ActiveIngredient;

public interface CatalogService {
    ActiveIngredient addIngredient(ActiveIngredient ingredient);
    Medication addMedication(Medication medication);
    Medication getMedication(Long id);  // ✅ added
}
