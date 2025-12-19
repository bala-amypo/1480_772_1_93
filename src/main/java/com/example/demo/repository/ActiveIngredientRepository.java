package com.example.demo.repository;

import com.example.demo.model.ActiveIngredientModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ActiveIngredientRepository extends JpaRepository<ActiveIngredientModel, Long> {
    Optional<ActiveIngredientModel> findByName(String name);
    boolean existsByName(String name);
}
