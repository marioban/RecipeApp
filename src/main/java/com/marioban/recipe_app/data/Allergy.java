package com.marioban.recipe_app.data;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Allergy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private AllergyType type;

    public enum AllergyType {
        GLUTEN, LACTOSE, NUTS, SEAFOOD, EGGS, SOY, SESAME, MUSTARD
    }
}