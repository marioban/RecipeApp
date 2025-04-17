package com.marioban.recipeapp.service;

import com.marioban.recipeapp.data.Recipe;
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
    public Optional<Recipe> findById(Integer id) {
        return recipeRepository.findById(id);
    }

    @Override
    public List<Recipe> findAll() {
        return recipeRepository.findAll();
    }

    @Override
    public List<Recipe> filterByCriteria(RecipeSearchForm recipeSearchForm) {
        return findAll()
                .stream()
                .filter(recipe -> recipe.getName().isBlank()
                        && recipe.getName().contains(recipeSearchForm.getRecipeName()))
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

        return recipeRepository.save(recipe);

//        Optional<Recipe> recipeToEditOptional = findById(recipeId);
//
//        if(recipeToEditOptional.isPresent()) {
//            Recipe recipeToEdit = recipeToEditOptional.get();
//            recipeToEdit.setName(recipe.getName());
//            recipeToEdit.setProtein(recipe.getProtein());
//            recipeToEdit.setFats(recipe.getFats());
//            recipeToEdit.setCarbs(recipe.getCarbs());
//            recipeToEdit.setKcal(recipe.getKcal());
//            recipeToEdit.setIngredients(recipe.getIngredients());
//            recipeToEdit.setPrice(recipe.getPrice());
//            return true;
//        } else {
//            return false;
//        }
    }
}
