package com.example.demo.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Medication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
        name = "medication_ingredient",
        joinColumns = @JoinColumn(name = "medication_id"),
        inverseJoinColumns = @JoinColumn(name = "ingredient_id")
    )
    private Set<ActiveIngredient> activeIngredients = new HashSet<>();

    // Add helper methods to maintain both sides of the relationship
    public void addIngredient(ActiveIngredient ingredient) {
        activeIngredients.add(ingredient);
        ingredient.getMedications().add(this);
    }

    public void removeIngredient(ActiveIngredient ingredient) {
        activeIngredients.remove(ingredient);
        ingredient.getMedications().remove(this);
    }

    // getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Set<ActiveIngredient> getActiveIngredients() { return activeIngredients; }
    public void setActiveIngredients(Set<ActiveIngredient> activeIngredients) { this.activeIngredients = activeIngredients; }
}
