package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "active_ingredients", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class ActiveIngredientModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    public ActiveIngredientModel() {}

    public ActiveIngredientModel(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
