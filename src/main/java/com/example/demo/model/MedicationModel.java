package com.example.demo.model;

import jakarta.persistence.*;
import java.util.List;

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
    private List<ActiveIngredientModel> ingredients;

    public MedicationModel() {}

    public MedicationModel(Long id, String name, List<ActiveIngredientModel> ingredients) {
        this.id = id;
        this.name = name;
        this.ingredients = ingredients;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public List<ActiveIngredientModel> getIngredients() { return ingredients; }
    public void setIngredients(List<ActiveIngredientModel> ingredients) { this.ingredients = ingredients; }
}
