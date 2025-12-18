package com.example.demo.service;

import org.springframework.stereotype.Service;
import java.util.List;

import com.example.demo.model.ActiveIngredientModel;
import com.example.demo.repository.ActiveIngredientRepository;

@Service
public class ActiveIngredientServiceImpl
        implements ActiveIngredientService {

    private final ActiveIngredientRepository repository;

    public ActiveIngredientServiceImpl(ActiveIngredientRepository repository) {
        this.repository = repository;
    }

    @Override
    public ActiveIngredientModel save(ActiveIngredientModel ingredient) {
        return repository.save(ingredient);
    }

    @Override
    public List<ActiveIngredientModel> getAll() {
        return repository.findAll();
    }
}
