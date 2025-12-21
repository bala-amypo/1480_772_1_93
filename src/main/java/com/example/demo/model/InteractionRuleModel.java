package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(
    uniqueConstraints = @UniqueConstraint(
        columnNames = {"ingredient_a_id", "ingredient_b_id"}
    )
)
public class InteractionRuleModel {

    // Inner ENUM (no separate file needed)
    public enum Severity {
        MINOR,
        MODERATE,
        MAJOR
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // First ingredient
    @ManyToOne
    @JoinColumn(name = "ingredient_a_id", nullable = false)
    private ActiveIngredientModel ingredientA;

    // Second ingredient
    @ManyToOne
    @JoinColumn(name = "ingredient_b_id", nullable = false)
    private ActiveIngredientModel ingredientB;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Severity severity;

    @Column(nullable = false)
    private String description;

    // Default constructor
    public InteractionRuleModel() {
    }

    // Optional constructor
    public InteractionRuleModel(
            Long id,
            ActiveIngredientModel ingredientA,
            ActiveIngredientModel ingredientB,
            Severity severity,
            String description) {

        this.id = id;
        this.ingredientA = ingredientA;
        this.ingredientB = ingredientB;
        this.severity = severity;
        this.description = description;
    }

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ActiveIngredientModel getIngredientA() {
        return ingredientA;
    }

    public void setIngredientA(ActiveIngredientModel ingredientA) {
        this.ingredientA = ingredientA;
    }

    public ActiveIngredientModel getIngredientB() {
        return ingredientB;
    }

    public void setIngredientB(ActiveIngredientModel ingredientB) {
        this.ingredientB = ingredientB;
    }

    public Severity getSeverity() {
        return severity;
    }

    public void setSeverity(Severity severity) {
        this.severity = severity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
