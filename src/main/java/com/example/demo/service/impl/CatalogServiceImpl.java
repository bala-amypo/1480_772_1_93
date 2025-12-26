// package com.example.demo.service.impl;

// import com.example.demo.model.Medication;
// import com.example.demo.model.ActiveIngredient;
// import com.example.demo.repository.MedicationRepository;
// import com.example.demo.repository.ActiveIngredientRepository;
// import com.example.demo.service.CatalogService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// @Service
// public class CatalogServiceImpl implements CatalogService {

//     @Autowired
//     private ActiveIngredientRepository ingredientRepository;

//     @Autowired
//     private MedicationRepository medicationRepository;

//     @Override
//     public ActiveIngredient addIngredient(ActiveIngredient ingredient) {
//         return ingredientRepository.save(ingredient);
//     }

//     @Override
//     public Medication addMedication(Medication medication) {
//         return medicationRepository.save(medication);
//     }

//     @Override
//     public Medication getMedication(Long id) {  // ✅ fix
//         return medicationRepository.findById(id)
//                 .orElseThrow(() -> new RuntimeException("Medication not found"));
//     }
// }

package com.example.demo.service.impl;

import com.example.demo.model.ActiveIngredient;
import com.example.demo.model.Medication;
import com.example.demo.repository.ActiveIngredientRepository;
import com.example.demo.repository.MedicationRepository;
import com.example.demo.service.CatalogService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CatalogServiceImpl implements CatalogService {
    private ActiveIngredientRepository ingredientRepository;
    private MedicationRepository medicationRepository;

    // Manual No-Args Constructor for Test Case #11
    public CatalogServiceImpl() {}

    public CatalogServiceImpl(ActiveIngredientRepository ingredientRepository, MedicationRepository medicationRepository) {
        this.ingredientRepository = ingredientRepository;
        this.medicationRepository = medicationRepository;
    }

    @Override
    public ActiveIngredient addIngredient(ActiveIngredient ingredient) {
        if (ingredientRepository.existsByName(ingredient.getName())) {
            throw new IllegalArgumentException("Ingredient already exists");
        }
        return ingredientRepository.save(ingredient);
    }

    @Override
    public Medication addMedication(Medication medication) {
        if (medication.getIngredients() == null || medication.getIngredients().isEmpty()) {
            throw new IllegalArgumentException("Medication must have at least one ingredient");
        }
        return medicationRepository.save(medication);
    }

    @Override
    public List<Medication> getAllMedications() {
        return medicationRepository.findAll();
    }
}