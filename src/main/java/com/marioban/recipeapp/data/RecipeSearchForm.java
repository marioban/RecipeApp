package com.marioban.recipeapp.data;

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
    private Integer minProtein;
    private Integer maxProtein;
    private Integer minCarbs;
    private Integer maxCarbs;
    private Integer minFats;
    private Integer maxFats;
}
