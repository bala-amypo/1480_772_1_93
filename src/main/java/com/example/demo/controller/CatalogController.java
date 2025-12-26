package com.example.demo.controller;

import com.example.demo.model.Medication;
import com.example.demo.model.ActiveIngredient;
import com.example.demo.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/catalog")
public class CatalogController {

    @Autowired
    private CatalogService catalogService;

    @PostMapping("/ingredients")
    public ResponseEntity<ActiveIngredient> addIngredient(@RequestBody ActiveIngredient ingredient) {
        return ResponseEntity.ok(catalogService.addIngredient(ingredient));
    }

    @PostMapping("/medications")
    public ResponseEntity<Medication> addMedication(@RequestBody Medication medication) {
        return ResponseEntity.ok(catalogService.addMedication(medication));
    }

    @GetMapping("/medications/{id}")
    public ResponseEntity<Medication> getMedication(@PathVariable Long id) {
        return ResponseEntity.ok(catalogService.getMedication(id));
    }
}
