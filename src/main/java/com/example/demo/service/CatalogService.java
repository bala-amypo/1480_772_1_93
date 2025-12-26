// package com.example.demo.service;

// import com.example.demo.model.Medication;
// import com.example.demo.model.ActiveIngredient;

// public interface CatalogService {
//     ActiveIngredient addIngredient(ActiveIngredient ingredient);
//     Medication addMedication(Medication medication);
//     Medication getMedication(Long id);  // ✅ added
// }


package com.example.demo.service;

import com.example.demo.model.ActiveIngredient;
import com.example.demo.model.Medication;
import java.util.List;

public interface CatalogService {
    ActiveIngredient addIngredient(ActiveIngredient ingredient);
    Medication addMedication(Medication medication);
    List<Medication> getAllMedications();
}