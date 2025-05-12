package com.marioban.recipe_app.controllers;

import com.marioban.recipe_app.data.Recipe;
import com.marioban.recipe_app.data.RecipeSearchForm;
import com.marioban.recipe_app.service.RecipeCategoryService;
import com.marioban.recipe_app.service.RecipeService;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/mvc")
@AllArgsConstructor
public class StartController {

    private RecipeService recipeService;
    private RecipeCategoryService recipeCategoryService;


    @GetMapping("/recipe")
    public String getAllRecipes(Model model) {
        model.addAttribute("recipeList", recipeService.findAll());
        model.addAttribute("recipeSearchForm", new RecipeSearchForm());
        model.addAttribute("recipe", new Recipe());
        return "recipe"; // recipe.html
    }

    @PostMapping("/searchRecipe")
    public String searchRecipe(Model model, @ModelAttribute RecipeSearchForm recipeSearchForm) {
        List<Recipe> filteredList = recipeService.filterByCriteria(recipeSearchForm);
        model.addAttribute("recipeList", filteredList);
        return "recipe";
    }

    @GetMapping("/saveRecipe")
    public String initializeSaveNewRecipeScreen(Model model) {
        model.addAttribute("recipeCategoryList", recipeCategoryService.findAll());
        model.addAttribute("recipe", new Recipe());
        return "saveRecipe"; // saveRecipe.html
    }

    @PostMapping("/saveRecipe")
    public String saveRecipe(@ModelAttribute Recipe recipe, Model model) {
        if (recipe.getId() == null) {
            recipeService.saveRecipe(recipe);
        } else {
            recipeService.editRecipe(recipe.getId(), recipe);
        }
        return "redirect:/mvc/recipe";
    }

    @PostMapping("/deleteRecipe")
    public String deleteRecipe(@RequestParam Integer recipeId) {
        recipeService.deleteRecipe(recipeId);
        return "redirect:/mvc/recipe";
    }

    @GetMapping("/editRecipe")
    public String initializeEditRecipeScreen(Model model, @RequestParam Integer recipeId) {
        model.addAttribute("recipe", recipeService.findById(recipeId));
        model.addAttribute("recipe", recipeService.findById(recipeId));
        return "saveRecipe";
    }
}
