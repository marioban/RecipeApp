package com.marioban.recipeapp.service;

import com.marioban.recipeapp.data.Recipe;
import com.marioban.recipeapp.data.RecipeDTO;
import com.marioban.recipeapp.data.RecipeSearchForm;

import java.util.List;
import java.util.Optional;

public interface RecipeService {
    Optional<RecipeDTO> findById(Integer id);
    List<Recipe> findAll();
    List<Recipe> filterByCriteria(RecipeSearchForm recipeSearchForm);
    void saveRecipe(Recipe recipe);
    void deleteRecipe(Integer recipeId);
    //void saveRecipeWithAllergies(Recipe recipe, List<Integer> allergyIds);
    Recipe editRecipe(Integer recipeId, Recipe recipe);
}
