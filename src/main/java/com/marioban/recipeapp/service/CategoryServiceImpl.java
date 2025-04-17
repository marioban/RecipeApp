package com.marioban.recipeapp.service;

import com.marioban.recipeapp.data.Category;
import com.marioban.recipeapp.repository.JpaCategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {
    private JpaCategoryRepository jpaCategoryRepository;


    @Override
    public List<Category> findAll() {
        return jpaCategoryRepository.findAll();
    }
}
