package com.example.demo.service;

import com.example.demo.model.MedicationModel;
import java.util.List;

public interface MedicationService {

    MedicationModel save(MedicationModel medication);

    List<MedicationModel> getAll();
}
