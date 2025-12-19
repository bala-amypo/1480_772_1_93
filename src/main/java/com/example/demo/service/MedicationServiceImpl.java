package com.example.demo.service;

import com.example.demo.model.MedicationModel;
import com.example.demo.repository.MedicationRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MedicationServiceImpl implements MedicationService {

    private final MedicationRepository medicationRepository;

    public MedicationServiceImpl(MedicationRepository medicationRepository) {
        this.medicationRepository = medicationRepository;
    }

    @Override
    public MedicationModel addMedication(MedicationModel medication) {
        if (medication.getIngredients() == null || medication.getIngredients().isEmpty()) {
            throw new RuntimeException("Medication must have at least one ingredient");
        }
        if (medicationRepository.existsByName(medication.getName())) {
            throw new RuntimeException("Medication name already exists");
        }
        return medicationRepository.save(medication);
    }

    @Override
    public List<MedicationModel> getAllMedications() {
        return medicationRepository.findAll();
    }

    @Override
    public MedicationModel getMedicationById(Long id) {
        return medicationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Medication not found with id: " + id));
    }
}
`