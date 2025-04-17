package com.marioban.recipeapp.repository;

import com.marioban.recipeapp.data.Allergy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaAllergyRepository extends JpaRepository<Allergy, Integer> {
}

