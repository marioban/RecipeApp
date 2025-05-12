package com.marioban.recipe_app.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecipeSearchForm {
    private String recipeName;
    private Integer maxKcal;
    private Integer minKcal;
    private BigDecimal priceMin;
    private BigDecimal priceMax;
}
