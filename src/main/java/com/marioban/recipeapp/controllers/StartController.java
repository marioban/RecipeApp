package com.marioban.recipeapp.controllers;

import com.marioban.recipeapp.data.Recipe;
import com.marioban.recipeapp.data.RecipeSearchForm;
import com.marioban.recipeapp.service.AllergyService;
import com.marioban.recipeapp.service.CategoryService;
import com.marioban.recipeapp.service.RecipeService;
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
    private AllergyService allergyService;
    private CategoryService categoryService;


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
        model.addAttribute("recipeCategoryList", categoryService.findAll());
        model.addAttribute("allergyList", allergyService.findAll());
        model.addAttribute("recipe", new Recipe());
        return "saveRecipe";
    }

    @GetMapping("/editRecipe")
    public String initializeEditRecipeScreen(Model model, @RequestParam Integer recipeId) {
        model.addAttribute("recipeCategoryList", categoryService.findAll());
        model.addAttribute("allergyList", allergyService.findAll());
        model.addAttribute("recipe", recipeService.findById(recipeId));
        return "saveRecipe";
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

    @PostMapping("/saveRecipe")
    public String saveRecipe(@ModelAttribute Recipe recipe,
                             @RequestParam(value = "allergyIds", required = false) List<Integer> allergyIds) {
        //recipeService.saveRecipeWithAllergies(recipe, allergyIds);
        return "redirect:/mvc/recipe";
    }


    @PostMapping("/deleteRecipe")
    public String deleteRecipe(@RequestParam Integer recipeId) {
        recipeService.deleteRecipe(recipeId);
        return "redirect:/mvc/recipe";
    }

}
