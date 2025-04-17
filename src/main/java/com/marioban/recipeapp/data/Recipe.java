package com.marioban.recipeapp.data;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer kcal;
    private Integer protein;
    private Integer carbs;
    private Integer fats;
    private String ingredients;
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToMany
    @JoinTable(
            name = "recipe_allergy",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "allergy_id")
    )
    private Set<Allergy> allergies = new HashSet<>();

    public void addAllergy(Allergy allergy) {
        this.allergies.add(allergy);
    }

    public void removeAllergy(Allergy allergy) {
        this.allergies.remove(allergy);
    }
}