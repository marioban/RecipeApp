package com.marioban.recipe_app.service;

import com.marioban.recipe_app.data.Category;

import java.util.List;

public interface RecipeCategoryService {
    List<Category> findAll();
}