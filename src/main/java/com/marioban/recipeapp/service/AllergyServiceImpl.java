package com.marioban.recipeapp.service;

import com.marioban.recipeapp.data.Allergy;
import com.marioban.recipeapp.repository.JpaAllergyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class AllergyServiceImpl implements AllergyService {
    private JpaAllergyRepository jpaAllegryRepository;

    @Override
    public List<Allergy> findAll() {
        return jpaAllegryRepository.findAll();
    }
}
