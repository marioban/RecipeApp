package com.marioban.recipe_app.service;

import com.marioban.recipe_app.data.Category;
import com.marioban.recipe_app.repository.JpaCategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class RecipeCategoryServiceImpl implements RecipeCategoryService {
    private JpaCategoryRepository jpaCategoryRepository;


    @Override
    public List<Category> findAll() {
        return jpaCategoryRepository.findAll();
    }
}
