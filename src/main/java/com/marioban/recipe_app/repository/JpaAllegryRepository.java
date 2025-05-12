package com.marioban.recipe_app.repository;

import com.marioban.recipe_app.data.Allergy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaAllegryRepository extends JpaRepository<Allergy, Integer> {
}
