// package com.example.demo.model;

// import jakarta.persistence.*;
// import java.util.HashSet;
// import java.util.Objects;
// import java.util.Set;

// @Entity
// @Table(name = "ingredients")
// public class ActiveIngredient {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private String name;

//     @ManyToMany(mappedBy = "ingredients")
//     private Set<Medication> medications = new HashSet<>();

//     public ActiveIngredient() {}
//     public ActiveIngredient(String name) { this.name = name; }

//     // Getters & Setters
//     public Long getId() { return id; }
//     public void setId(Long id) { this.id = id; }

//     public String getName() { return name; }
//     public void setName(String name) { this.name = name; }

//     public Set<Medication> getMedications() { return medications; }
//     public void setMedications(Set<Medication> medications) { this.medications = medications; }

//     @Override
//     public boolean equals(Object o) {
//         if (this == o) return true;
//         if (!(o instanceof ActiveIngredient)) return false;
//         ActiveIngredient that = (ActiveIngredient) o;
//         return Objects.equals(getId(), that.getId());
//     }

//     @Override
//     public int hashCode() {
//         return Objects.hash(getId());
//     }
// }



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