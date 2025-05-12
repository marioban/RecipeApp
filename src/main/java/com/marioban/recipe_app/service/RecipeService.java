package com.marioban.recipe_app.service;

import com.marioban.recipe_app.data.Recipe;
import com.marioban.recipe_app.data.RecipeSearchForm;

import java.util.List;
import java.util.Optional;

public interface RecipeService {
    Optional<Recipe> findById(Integer id);
    List<Recipe> findAll();
    List<Recipe> filterByCriteria(RecipeSearchForm recipeSearchForm);
    void saveRecipe(Recipe recipe);
    void deleteRecipe(Integer recipeId);
    Recipe editRecipe(Integer recipeId, Recipe recipe);
}
