package com.nanoka.pasteleria.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ingredient_stocks")
@FieldDefaults(level = AccessLevel.PRIVATE)

public class IngredientStock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne(targetEntity = Ingredient.class)
    Ingredient ingredient;
    Double quantity;
    Double price;
}
