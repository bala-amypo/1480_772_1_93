package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.InteractionService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class InteractionServiceImpl implements InteractionService {

    private final MedicationRepository medicationRepository;
    private final InteractionRuleRepository ruleRepository;
    private final InteractionCheckResultRepository resultRepository;

    public InteractionServiceImpl(MedicationRepository medicationRepository,
                                  InteractionRuleRepository ruleRepository,
                                  InteractionCheckResultRepository resultRepository) {
        this.medicationRepository = medicationRepository;
        this.ruleRepository = ruleRepository;
        this.resultRepository = resultRepository;
    }

    @Override
    public InteractionCheckResult checkInteractions(List<Long> medicationIds) {

        List<Medication> medications =
                medicationRepository.findAllById(medicationIds);

        if (medications.isEmpty()) {
            throw new IllegalArgumentException("No medications provided");
        }

        Set<ActiveIngredient> ingredients = new HashSet<>();
        medications.forEach(m -> ingredients.addAll(m.getIngredients()));

        List<InteractionRule> detected = new ArrayList<>();

        for (ActiveIngredient a : ingredients) {
            for (ActiveIngredient b : ingredients) {
                if (!a.getId().equals(b.getId())) {
                    ruleRepository
                      .findByIngredientAIdAndIngredientBId(a.getId(), b.getId())
                      .ifPresent(detected::add);
                }
            }
        }

        String meds = medications.stream()
                .map(Medication::getName)
                .reduce((x, y) -> x + "," + y)
                .orElse("");

        String json = "{ \"interactionCount\": " + detected.size() + " }";

        InteractionCheckResult result =
                new InteractionCheckResult(meds, json);

        return resultRepository.save(result);
    }

    @Override
    public InteractionCheckResult getResult(Long resultId) {
        return resultRepository.findById(resultId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Result not found"));
    }
}
