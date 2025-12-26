package com.example.demo.service;

import com.example.demo.model.InteractionCheckResult;
import com.example.demo.repository.InteractionCheckResultRepository;
import com.example.demo.service.InteractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class InteractionServiceImpl implements InteractionService {

    @Autowired
    private InteractionCheckResultRepository resultRepository;

    @Override
    public InteractionCheckResult checkInteractions(List<Long> medicationIds) {
        // Simulate interaction check result
        InteractionCheckResult result = new InteractionCheckResult();
        result.setInteractions("{\"interactions\": []}");
        result.setCheckedAt(LocalDateTime.now());
        return resultRepository.save(result);
    }

    @Override
    public InteractionCheckResult getResult(Long id) {
        return resultRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Result not found"));
    }
}
