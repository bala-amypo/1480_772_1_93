package com.example.demo.service;

import com.example.demo.model.ActiveIngredientModel;
import java.util.List;

public interface ActiveIngredientService {

    ActiveIngredientModel addIngredient(ActiveIngredientModel ingredient);

    List<ActiveIngredientModel> getAllIngredients();

    ActiveIngredientModel getIngredientById(Long id);
}
