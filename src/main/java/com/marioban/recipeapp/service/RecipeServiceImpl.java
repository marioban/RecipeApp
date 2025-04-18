package com.marioban.recipeapp.service;

import com.marioban.recipeapp.data.Recipe;
import com.marioban.recipeapp.data.RecipeDTO;
import com.marioban.recipeapp.data.RecipeSearchForm;
import com.marioban.recipeapp.repository.JpaRecipeRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class RecipeServiceImpl implements RecipeService {
    private final JpaRecipeRepository recipeRepository;

    @Override
    public Optional<RecipeDTO> findById(Integer id) {
        return recipeRepository.findById(id).map(this::convertToDto);
    }

    @Override
    public List<Recipe> findAll() {
        return recipeRepository.findAll();
    }

    @Override
    public List<Recipe> filterByCriteria(RecipeSearchForm recipeSearchForm) {
        return findAll().stream()
                .filter(recipe -> {
                    boolean matches = true;

                    if (recipeSearchForm.getRecipeName() != null && !recipeSearchForm.getRecipeName().isBlank()) {
                        matches = matches && recipe.getName() != null &&
                                recipe.getName().toLowerCase().contains(recipeSearchForm.getRecipeName().toLowerCase());
                    }
                    if (recipeSearchForm.getMinKcal() != null) {
                        matches = matches && recipe.getKcal() != null && recipe.getKcal() >= recipeSearchForm.getMinKcal();
                    }
                    if (recipeSearchForm.getMaxKcal() != null) {
                        matches = matches && recipe.getKcal() != null && recipe.getKcal() <= recipeSearchForm.getMaxKcal();
                    }
                    if (recipeSearchForm.getMinProtein() != null) {
                        matches = matches && recipe.getProtein() != null && recipe.getProtein() >= recipeSearchForm.getMinProtein();
                    }
                    if (recipeSearchForm.getMaxProtein() != null) {
                        matches = matches && recipe.getProtein() != null && recipe.getProtein() <= recipeSearchForm.getMaxProtein();
                    }
                    if (recipeSearchForm.getMinCarbs() != null) {
                        matches = matches && recipe.getCarbs() != null && recipe.getCarbs() >= recipeSearchForm.getMinCarbs();
                    }
                    if (recipeSearchForm.getMaxCarbs() != null) {
                        matches = matches && recipe.getCarbs() != null && recipe.getCarbs() <= recipeSearchForm.getMaxCarbs();
                    }
                    if (recipeSearchForm.getMinFats() != null) {
                        matches = matches && recipe.getFats() != null && recipe.getFats() >= recipeSearchForm.getMinFats();
                    }
                    if (recipeSearchForm.getMaxFats() != null) {
                        matches = matches && recipe.getFats() != null && recipe.getFats() <= recipeSearchForm.getMaxFats();
                    }

                    return matches;
                })
                .toList();
    }



    @Override
    public void saveRecipe(Recipe recipe) {
        recipeRepository.save(recipe);
    }

    @Override
    public void deleteRecipe(Integer recipeId) {
        recipeRepository.deleteById(recipeId);
    }

    @Override
    public Recipe editRecipe(Integer recipeId, Recipe recipe) {
        Optional<Recipe> existingRecipeOptional = recipeRepository.findById(recipeId);

        if (existingRecipeOptional.isPresent()) {
            Recipe existingRecipe = existingRecipeOptional.get();

            existingRecipe.setName(recipe.getName());
            existingRecipe.setKcal(recipe.getKcal());
            existingRecipe.setProtein(recipe.getProtein());
            existingRecipe.setCarbs(recipe.getCarbs());
            existingRecipe.setFats(recipe.getFats());
            existingRecipe.setIngredients(recipe.getIngredients());
            existingRecipe.setPrice(recipe.getPrice());
            existingRecipe.setCategory(recipe.getCategory());
            existingRecipe.setAllergies(recipe.getAllergies());

            return recipeRepository.save(existingRecipe);
        } else {
            throw new IllegalArgumentException("Recipe with ID " + recipeId + " not found.");
        }
    }


    private RecipeDTO convertToDto(Recipe recipe) {
        return new RecipeDTO(
                recipe.getId(),
                recipe.getName(),
                recipe.getKcal(),
                recipe.getProtein(),
                recipe.getCarbs(),
                recipe.getFats(),
                recipe.getPrice(),
                recipe.getCategory() != null ? recipe.getCategory().getName() : null,
                recipe.getAllergies()
                        .stream()
                        .map(allergy -> allergy.getType().toString())
                        .toList(),
                recipe.getIngredients()
        );
    }
}
