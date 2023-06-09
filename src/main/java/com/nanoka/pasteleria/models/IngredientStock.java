package com.nanoka.pasteleria.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;

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
    @Column(precision = 8, scale = 4)
    BigDecimal quantity;
    @Column(precision = 8, scale = 4)
    BigDecimal price;
    @UpdateTimestamp
    @Column(name = "updated_at")
    LocalDateTime updatedAt;
}
