// package com.example.demo.service.impl;

// import com.example.demo.exception.ResourceNotFoundException;
// import com.example.demo.model.InteractionCheckResult;
// import com.example.demo.repository.InteractionCheckResultRepository;
// import com.example.demo.repository.InteractionRuleRepository;
// import com.example.demo.repository.MedicationRepository;
// import com.example.demo.service.InteractionService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import java.time.LocalDateTime;
// import java.util.List;

// @Service
// public class InteractionServiceImpl implements InteractionService {

//     private MedicationRepository medicationRepository;
//     private InteractionRuleRepository ruleRepository;
//     private InteractionCheckResultRepository resultRepository;

//     // Keep empty constructor for your specific test case requirements
//     public InteractionServiceImpl() {}

//     /**
//      * @Autowired is MANDATORY here to fix the "null" repository error.
//      * It ensures Spring connects to your database repositories.
//      */
//     @Autowired
//     public InteractionServiceImpl(MedicationRepository medicationRepository, 
//                                   InteractionRuleRepository ruleRepository, 
//                                   InteractionCheckResultRepository resultRepository) {
//         this.medicationRepository = medicationRepository;
//         this.ruleRepository = ruleRepository;
//         this.resultRepository = resultRepository;
//     }

//     @Override
//     public InteractionCheckResult checkInteractions(List<Long> medicationIds) {
//         // Create a new result object
//         InteractionCheckResult result = new InteractionCheckResult();
        
//         // Convert list of IDs to a string for storage (as per your schema)
//         result.setMedications(medicationIds.toString());
        
//         // Placeholder for logic - you can implement actual interaction 
//         // logic here using ruleRepository later.
//         result.setInteractions("Interaction check completed for medications: " + medicationIds);
//         result.setCheckedAt(LocalDateTime.now());

//         // Now resultRepository will NOT be null because of @Autowired
//         return resultRepository.save(result);
//     }

//     @Override
//     public InteractionCheckResult getResult(Long resultId) {
//         return resultRepository.findById(resultId)
//                 .orElseThrow(() -> new ResourceNotFoundException("Result not found with ID: " + resultId));
//     }
// }




package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.InteractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InteractionServiceImpl implements InteractionService {

    private final MedicationRepository medicationRepository;
    private final InteractionRuleRepository ruleRepository;
    private final InteractionCheckResultRepository resultRepository;

    public InteractionServiceImpl() {
        this.medicationRepository = null;
        this.ruleRepository = null;
        this.resultRepository = null;
    }

    @Autowired
    public InteractionServiceImpl(MedicationRepository medicationRepository, 
                                  InteractionRuleRepository ruleRepository, 
                                  InteractionCheckResultRepository resultRepository) {
        this.medicationRepository = medicationRepository;
        this.ruleRepository = ruleRepository;
        this.resultRepository = resultRepository;
    }

    @Override
    public InteractionCheckResult checkInteractions(List<Long> medicationIds) {
        // 1. Fetch full Medication objects from the database
        List<Medication> medications = medicationRepository.findAllById(medicationIds);
        
        // 2. Collect all unique ingredients from these medications
        List<ActiveIngredient> ingredients = medications.stream()
                .flatMap(m -> m.getIngredients().stream())
                .distinct()
                .collect(Collectors.toList());

        List<String> foundInteractions = new ArrayList<>();

        // 3. Compare every pair of ingredients against the Rules table
        for (int i = 0; i < ingredients.size(); i++) {
            for (int j = i + 1; j < ingredients.size(); j++) {
                ActiveIngredient ingA = ingredients.get(i);
                ActiveIngredient ingB = ingredients.get(j);

                // Check for rules where (A, B) or (B, A) matches
                List<InteractionRule> rules = ruleRepository.findAll().stream()
                    .filter(r -> (r.getIngredientA().getId().equals(ingA.getId()) && r.getIngredientB().getId().equals(ingB.getId())) ||
                                 (r.getIngredientA().getId().equals(ingB.getId()) && r.getIngredientB().getId().equals(ingA.getId())))
                    .collect(Collectors.toList());

                for (InteractionRule rule : rules) {
                    foundInteractions.add(rule.getSeverity() + ": " + rule.getDescription());
                }
            }
        }

        // 4. Create and save the result
        InteractionCheckResult result = new InteractionCheckResult();
        
        // Format names for the output
        String medNames = medications.stream().map(Medication::getName).collect(Collectors.joining(", "));
        result.setMedications(medNames);

        if (foundInteractions.isEmpty()) {
            result.setInteractions("No interactions found.");
        } else {
            result.setInteractions(String.join(" | ", foundInteractions));
        }

        result.setCheckedAt(LocalDateTime.now());
        return resultRepository.save(result);
    }

    @Override
    public InteractionCheckResult getResult(Long resultId) {
        return resultRepository.findById(resultId)
                .orElseThrow(() -> new ResourceNotFoundException("Result not found with ID: " + resultId));
    }
}