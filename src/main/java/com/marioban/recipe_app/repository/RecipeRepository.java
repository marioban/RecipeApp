package com.marioban.recipe_app.repository;

import com.marioban.recipe_app.data.Recipe;

import java.util.List;
import java.util.Optional;

public interface RecipeRepository {
    Optional<Recipe> findById(Integer id);
    List<Recipe> findAll();
}
