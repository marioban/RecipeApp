package com.marioban.recipeapp.repository;

import com.marioban.recipeapp.data.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaCategoryRepository extends JpaRepository<Category, Integer> {
}
