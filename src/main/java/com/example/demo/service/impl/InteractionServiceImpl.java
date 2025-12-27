
// package com.example.demo.service.impl;

// import com.example.demo.exception.ResourceNotFoundException;
// import com.example.demo.model.InteractionCheckResult;
// import com.example.demo.repository.InteractionCheckResultRepository;
// import com.example.demo.repository.InteractionRuleRepository;
// import com.example.demo.repository.MedicationRepository;
// import com.example.demo.service.InteractionService;
// import org.springframework.stereotype.Service;
// import java.util.List;

// @Service
// public class InteractionServiceImpl implements InteractionService {
//     private MedicationRepository medicationRepository;
//     private InteractionRuleRepository ruleRepository;
//     private InteractionCheckResultRepository resultRepository;

//     // MANDATORY: Add this to pass Test Case line 253
//     public InteractionServiceImpl() {}

//     public InteractionServiceImpl(MedicationRepository medicationRepository, 
//                                   InteractionRuleRepository ruleRepository, 
//                                   InteractionCheckResultRepository resultRepository) {
//         this.medicationRepository = medicationRepository;
//         this.ruleRepository = ruleRepository;
//         this.resultRepository = resultRepository;
//     }

//     @Override
//     public InteractionCheckResult checkInteractions(List<Long> medicationIds) {
//         return resultRepository.save(new InteractionCheckResult("Meds", "{}"));
//     }

//     @Override
//     public InteractionCheckResult getResult(Long resultId) {
//         return resultRepository.findById(resultId)
//                 .orElseThrow(() -> new ResourceNotFoundException("Result not found"));
//     }
// }




package com.example.demo.service.impl;

import com.example.demo.model.ActiveIngredient;
import com.example.demo.repository.ActiveIngredientRepository;
import com.example.demo.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientService {

    private ActiveIngredientRepository ingredientRepository;

    // Optional: Keep this if your test cases require an empty constructor
    public IngredientServiceImpl() {}

    /**
     * @Autowired tells Spring to inject the database repository.
     * This prevents the "null" error you are seeing.
     */
    @Autowired
    public IngredientServiceImpl(ActiveIngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public ActiveIngredient addIngredient(ActiveIngredient ingredient) {
        // Now ingredientRepository will NOT be null
        return ingredientRepository.save(ingredient);
    }

    @Override
    public List<ActiveIngredient> getAllIngredients() {
        return ingredientRepository.findAll();
    }

    @Override
    public ActiveIngredient getIngredientById(Long id) {
        return ingredientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ingredient not found with ID: " + id));
    }
}