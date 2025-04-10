package com.marioban.recipe_app.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Food {
    private Integer id;
    private String name;
    private String kcal;
    private BigDecimal price;
}
