package com.example.demo.service;

import org.springframework.stereotype.Service;
import java.util.List;

import com.example.demo.model.InteractionRuleModel;
import com.example.demo.repository.InteractionRuleRepository;

@Service
public class InteractionRuleServiceImpl
        implements InteractionRuleService {

    private final InteractionRuleRepository repository;

    public InteractionRuleServiceImpl(
            InteractionRuleRepository repository) {
        this.repository = repository;
    }

    @Override
    public InteractionRuleModel saveRule(InteractionRuleModel rule) {
        return repository.save(rule);
    }

    @Override
    public List<InteractionRuleModel> getAllRules() {
        return repository.findAll();
    }

    @Override
    public InteractionRuleModel checkInteraction(
            String medA, String medB) {

        return repository
                .findByMedicationAAndMedicationB(medA, medB)
                .orElse(null);
    }
}

