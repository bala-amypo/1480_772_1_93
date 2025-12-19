package com.example.demo.controller;

import com.example.demo.model.MedicationModel;
import com.example.demo.service.MedicationService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/catalog")
public class MedicationController {

    private final MedicationService medicationService;

    public MedicationController(MedicationService medicationService) {
        this.medicationService = medicationService;
    }

    @PostMapping("/medication")
    public MedicationModel addMedication(@RequestBody MedicationModel medication) {
        return medicationService.addMedication(medication);
    }

    @GetMapping("/medications")
    public List<MedicationModel> getAllMedications() {
        return medicationService.getAllMedications();
    }

    @GetMapping("/medication/{id}")
    public MedicationModel getMedication(@PathVariable Long id) {
        return medicationService.getMedicationById(id);
    }
}
