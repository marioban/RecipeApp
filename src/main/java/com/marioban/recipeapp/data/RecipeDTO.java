package com.marioban.recipeapp.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
public class RecipeDTO {
    private Integer id;
    private String name;
    private Integer kcal;
    private Integer protein;
    private Integer carbs;
    private Integer fats;
    private BigDecimal price;
    private String categoryName;
    private List<String> allergies;
    private String ingredients;
}
