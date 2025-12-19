package com.example.demo.service;

import com.example.demo.model.MedicationModel;
import java.util.List;

public interface MedicationService {
    MedicationModel addMedication(MedicationModel medication);
    List<MedicationModel> getAllMedications();
    MedicationModel getMedicationById(Long id);
}
