package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class InteractionRuleModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // first medication name
    private String medicationA;

    // second medication name
    private String medicationB;

    // description of interaction
    private String description;

    // severity level (LOW / MEDIUM / HIGH)
    private String severity;

    // constructors
    public InteractionRuleModel() {
    }

    public InteractionRuleModel(
            Long id,
            String medicationA,
            String medicationB,
            String description,
            String severity) {
        this.id = id;
        this.medicationA = medicationA;
        this.medicationB = medicationB;
        this.description = description;
        this.severity = severity;
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
}
