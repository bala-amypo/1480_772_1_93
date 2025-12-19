package com.example.demo.service;

import com.example.demo.model.InteractionCheckResultModel;
import com.example.demo.repository.InteractionCheckResultRepository;
import org.springframework.stereotype.Service;

@Service
public class InteractionCheckResultServiceImpl implements InteractionCheckResultService {

    private final InteractionCheckResultRepository resultRepository;

    public InteractionCheckResultServiceImpl(InteractionCheckResultRepository resultRepository) {
        this.resultRepository = resultRepository;
    }

    @Override
    public InteractionCheckResultModel getResultById(Long id) {
        return resultRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Interaction check result not found with id: " + id));
    }
}
