package com.marioban.recipe_app.service;

import com.marioban.recipe_app.data.Allergy;

import java.util.List;

public interface RecipeAllergyService {
    List<Allergy> findAll();
}
