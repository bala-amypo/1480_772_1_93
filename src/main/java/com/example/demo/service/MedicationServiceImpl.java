package com.example.demo.service;

import org.springframework.stereotype.Service;
import java.util.List;

import com.example.demo.model.MedicationModel;
import com.example.demo.repository.MedicationRepository;

@Service
public class MedicationServiceImpl
        implements MedicationService {

    private final MedicationRepository repository;

    public MedicationServiceImpl(MedicationRepository repository) {
        this.repository = repository;
    }

    @Override
    public MedicationModel save(MedicationModel medication) {
        return repository.save(medication);
    }

    @Override
    public List<MedicationModel> getAll() {
        return repository.findAll();
    }
}

