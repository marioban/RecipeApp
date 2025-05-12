package com.marioban.recipe_app.repository;

import com.marioban.recipe_app.data.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaCategoryRepository extends JpaRepository<Category, Integer> {
}
