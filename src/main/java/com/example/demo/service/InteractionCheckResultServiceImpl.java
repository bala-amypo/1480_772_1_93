package com.example.demo.service;

import org.springframework.stereotype.Service;
import java.util.List;

import com.example.demo.model.InteractionCheckResultModel;
import com.example.demo.repository.InteractionCheckResultRepository;

@Service
public class InteractionCheckResultServiceImpl
        implements InteractionCheckResultService {

    private final InteractionCheckResultRepository repository;

    public InteractionCheckResultServiceImpl(
            InteractionCheckResultRepository repository) {
        this.repository = repository;
    }

    @Override
    public InteractionCheckResultModel saveResult(
            InteractionCheckResultModel result) {
        return repository.save(result);
    }

    @Override
    public List<InteractionCheckResultModel> getAllResults() {
        return repository.findAll();
    }

    @Override
    public InteractionCheckResultModel getResultById(Long id) {
        return repository.findById(id).orElse(null);
    }
}
