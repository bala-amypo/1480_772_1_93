package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class InteractionCheckResultModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // medications checked
    private String medicationA;
    private String medicationB;

    // result details
    private String description;
    private String severity;

    // status (SAFE / WARNING / DANGEROUS)
    private String status;

    // constructors
    public InteractionCheckResultModel() {
    }

    public InteractionCheckResultModel(
            Long id,
            String medicationA,
            String medicationB,
            String description,
            String severity,
            String status) {
        this.id = id;
        this.medicationA = medicationA;
        this.medicationB = medicationB;
        this.description = description;
        this.severity = severity;
        this.status = status;
    }

    // getters & setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMedicationA() {
        return medicationA;
    }

    public void setMedicationA(String medicationA) {
        this.medicationA = medicationA;
    }

    public String getMedicationB() {
        return medicationB;
    }

    public void setMedicationB(String medicationB) {
        this.medicationB = medicationB;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
