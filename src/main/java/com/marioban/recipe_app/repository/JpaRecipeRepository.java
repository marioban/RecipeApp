package com.marioban.recipe_app.repository;

import com.marioban.recipe_app.data.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaRecipeRepository extends JpaRepository<Recipe, Integer> {
}
