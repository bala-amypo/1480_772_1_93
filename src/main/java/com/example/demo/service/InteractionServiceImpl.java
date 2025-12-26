package com.example.demo.service;

import com.example.demo.model.InteractionCheckResult;
import com.example.demo.model.Medication;
import com.example.demo.repository.InteractionCheckResultRepository;
import com.example.demo.repository.MedicationRepository;
import com.example.demo.service.InteractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InteractionServiceImpl implements InteractionService {

    @Autowired
    private MedicationRepository medicationRepository;

    @Autowired
    private InteractionCheckResultRepository resultRepository;

    @Override
    public InteractionCheckResult checkInteractions(List<Long> medicationIds) {
        // For simplicity, create a mock JSON response
        String medications = String.join(",",
                medicationIds.stream().map(String::valueOf).toArray(String[]::new));
        String interactionsJson = "{\"interactions\": []}";

        InteractionCheckResult result = new InteractionCheckResult(medications, interactionsJson);
        return resultRepository.save(result);
    }

    @Override
    public InteractionCheckResult getResult(Long id) {
        return resultRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Result not found"));
    }
}
