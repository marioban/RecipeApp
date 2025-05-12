package com.marioban.recipe_app.service;

import com.marioban.recipe_app.data.Allergy;
import com.marioban.recipe_app.repository.JpaAllegryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class RecipeAllergyServiceImpl implements RecipeAllergyService{
    private JpaAllegryRepository jpaAllegryRepository;

    @Override
    public List<Allergy> findAll() {
        return jpaAllegryRepository.findAll();
    }
}
