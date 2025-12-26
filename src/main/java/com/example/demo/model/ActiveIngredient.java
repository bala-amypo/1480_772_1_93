
package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "active_ingredients")
public class ActiveIngredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    // No-arg constructor (Rule 2.2)
    public ActiveIngredient() {}

    // Field constructor (Rule 2.2)
    public ActiveIngredient(String name) {
        this.name = name;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}