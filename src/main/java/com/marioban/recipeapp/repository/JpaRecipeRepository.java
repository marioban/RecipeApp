package com.marioban.recipeapp.repository;

import com.marioban.recipeapp.data.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaRecipeRepository extends JpaRepository<Recipe, Integer> {
}
