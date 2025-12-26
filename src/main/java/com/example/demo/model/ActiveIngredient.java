package com.example.demo.model;

import jakarta.persistence.*;
import java.util.*;

@Entity
public class ActiveIngredient {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "ingredients")
    private Set<Medication> medications = new HashSet<>();

    public ActiveIngredient() {}
    public ActiveIngredient(String name) { this.name = name; }

    // Getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
