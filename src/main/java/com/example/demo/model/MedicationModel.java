package com.example.demo.model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "medications")
public class MedicationModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToMany
    @JoinTable(
        name = "medication_ingredients",
        joinColumns = @JoinColumn(name = "medication_id"),
        inverseJoinColumns = @JoinColumn(name = "ingredient_id")
    )
    private Set<ActiveIngredientModel> ingredients;

    public MedicationModel() {}

    public MedicationModel(Long id, String name, Set<ActiveIngredientModel> ingredients) {
        this.id = id;
        this.name = name;
        this.ingredients = ingredients;
    }

    @PrePersist
    private void validateIngredients() {
        if (ingredients == null || ingredients.isEmpty()) {
            throw new IllegalArgumentException("Medication must have at least one ingredient");
        }
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Set<ActiveIngredientModel> getIngredients() { return ingredients; }
    public void setIngredients(Set<ActiveIngredientModel> ingredients) { this.ingredients = ingredients; }
}
