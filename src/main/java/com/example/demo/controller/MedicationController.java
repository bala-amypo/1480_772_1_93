package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.example.demo.model.MedicationModel;
import com.example.demo.service.MedicationService;

@RestController
@RequestMapping("/medications")
public class MedicationController {

    private final MedicationService service;

    public MedicationController(MedicationService service) {
        this.service = service;
    }

    @PostMapping
    public MedicationModel addMedication(
            @RequestBody MedicationModel medication) {
        return service.save(medication);
    }

    @GetMapping
    public List<MedicationModel> getAllMedications() {
        return service.getAll();
    }
}
