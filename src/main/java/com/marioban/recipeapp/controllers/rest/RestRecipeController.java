package com.marioban.recipeapp.controllers.rest;

import com.marioban.recipeapp.data.Recipe;
import com.marioban.recipeapp.data.RecipeDTO;
import com.marioban.recipeapp.data.RecipeSearchForm;
import com.marioban.recipeapp.service.RecipeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/recipe")
@AllArgsConstructor
public class RestRecipeController {

    private final RecipeService recipeService;

    @GetMapping("/all")
    public ResponseEntity<List<Recipe>> getAllRecipes() {
        List<Recipe> allRecipes = recipeService.findAll();
        return new ResponseEntity<>(allRecipes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecipeDTO> getRecipeById(@PathVariable Integer id) {
        Optional<RecipeDTO> optionalRecipe = recipeService.findById(id);
        return optionalRecipe.map(recipeDTO -> new ResponseEntity<>(recipeDTO, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Recipe> createRecipe(@RequestBody Recipe recipe) {
        recipeService.saveRecipe(recipe);
        return new ResponseEntity<>(recipe, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Recipe> updateRecipe(@PathVariable Integer id, @RequestBody Recipe recipe) {
        Recipe updatedRecipe = recipeService.editRecipe(id, recipe);
        return new ResponseEntity<>(updatedRecipe, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecipe(@PathVariable Integer id) {
        recipeService.deleteRecipe(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/search")
    public ResponseEntity<List<Recipe>> searchRecipes(@RequestBody RecipeSearchForm searchForm) {
        List<Recipe> filteredRecipes = recipeService.filterByCriteria(searchForm);
        return new ResponseEntity<>(filteredRecipes, HttpStatus.OK);
    }
}
