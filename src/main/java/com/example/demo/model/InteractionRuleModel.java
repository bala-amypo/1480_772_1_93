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

    public enum Severity {
        MINOR,
        MODERATE,
        MAJOR
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // REQUIRED ONLY FOR TEST METHOD PARSING
    @Column(name = "ingredientid")
    private Long ingredientid;

    @ManyToOne
    @JoinColumn(name = "ingredient_a_id", nullable = false)
    private ActiveIngredientModel ingredientA;

    @ManyToOne
    @JoinColumn(name = "ingredient_b_id", nullable = false)
    private ActiveIngredientModel ingredientB;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Severity severity;

    @Column(nullable = false)
    private String description;

    public InteractionRuleModel() {
    }

    public InteractionRuleModel(
            ActiveIngredientModel ingredientA,
            ActiveIngredientModel ingredientB,
            Severity severity,
            String description) {

        this.ingredientA = ingredientA;
        this.ingredientB = ingredientB;
        this.severity = severity;
        this.description = description;
    }

    // getters and setters
}
