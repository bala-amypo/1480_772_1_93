package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "interaction_rules",
       uniqueConstraints = @UniqueConstraint(columnNames = {"ingredient_a_id", "ingredient_b_id"}))
public class InteractionRuleModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ingredient_a_id", nullable = false)
    private ActiveIngredientModel ingredientA;

    @ManyToOne
    @JoinColumn(name = "ingredient_b_id", nullable = false)
    private ActiveIngredientModel ingredientB;

    @Column(nullable = false)
    private String severity; // MINOR / MODERATE / MAJOR

    @Column(nullable = false)
    private String description;

    public InteractionRuleModel() {}

    public InteractionRuleModel(Long id, ActiveIngredientModel ingredientA, ActiveIngredientModel ingredientB,
                                String severity, String description) {
        this.id = id;
        this.ingredientA = ingredientA;
        this.ingredientB = ingredientB;
        this.severity = severity;
        this.description = description;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public ActiveIngredientModel getIngredientA() { return ingredientA; }
    public void setIngredientA(ActiveIngredientModel ingredientA) { this.ingredientA = ingredientA; }

    public ActiveIngredientModel getIngredientB() { return ingredientB; }
    public void setIngredientB(ActiveIngredientModel ingredientB) { this.ingredientB = ingredientB; }

    public String getSeverity() { return severity; }
    public void setSeverity(String severity) { this.severity = severity; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
