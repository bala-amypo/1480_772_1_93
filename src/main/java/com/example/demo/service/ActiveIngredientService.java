package com.example.demo.service;

import com.example.demo.model.ActiveIngredientModel;
import java.util.List;

public interface ActiveIngredientService {

    ActiveIngredientModel save(ActiveIngredientModel ingredient);

    List<ActiveIngredientModel> getAll();
}

