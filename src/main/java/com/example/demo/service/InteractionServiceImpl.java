package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.InteractionService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class InteractionServiceImpl implements InteractionService {

    private final MedicationRepository medicationRepo;
    private final InteractionRuleRepository ruleRepo;
    private final InteractionCheckResultRepository resultRepo;

    public InteractionServiceImpl(MedicationRepository medicationRepo,
                                  InteractionRuleRepository ruleRepo,
                                  InteractionCheckResultRepository resultRepo) {
        this.medicationRepo = medicationRepo;
        this.ruleRepo = ruleRepo;
        this.resultRepo = resultRepo;
    }

    @Override
    public InteractionCheckResult checkInteractions(List<Long> medicationIds) {

        List<Medication> medications =
                medicationRepo.findAllById(medicationIds);

        if (medications.isEmpty()) {
            throw new IllegalArgumentException("No medications found");
        }

        Set<ActiveIngredient> ingredients = new HashSet<>();
        medications.forEach(m -> ingredients.addAll(m.getIngredients()));

        List<String> interactions = new ArrayList<>();
        List<ActiveIngredient> list = new ArrayList<>(ingredients);

        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {

                ruleRepo.findRuleBetweenIngredients(
                        list.get(i).getId(),
                        list.get(j).getId()
                ).ifPresent(rule ->
                        interactions.add(
                            rule.getIngredientA().getName()
                            + " - "
                            + rule.getIngredientB().getName()
                            + " : "
                            + rule.getSeverity()
                        )
                );
            }
        }

        String meds =
                medications.stream()
                        .map(Medication::getName)
                        .reduce((a, b) -> a + "," + b)
                        .orElse("");

        String json = interactions.toString();

        InteractionCheckResult result =
                new InteractionCheckResult(meds, json);

        return resultRepo.save(result);
    }

    @Override
    public InteractionCheckResult getResult(Long id) {
        return resultRepo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Result not found"));
    }
}
