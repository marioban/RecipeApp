package com.marioban.recipeapp.repository;

import com.marioban.recipeapp.data.Recipe;

import java.util.List;
import java.util.Optional;

public interface RecipeRepository {
    Optional<com.marioban.recipeapp.data.Recipe> findById(Integer id);
    List<Recipe> findAll();
}
