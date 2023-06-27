package com.nanoka.pasteleria.models;

import java.math.BigDecimal;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ingredients")
@FieldDefaults(level = AccessLevel.PRIVATE)

public class ProductIngredient {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne(targetEntity = Product.class)
    Product product;
    @ManyToOne(targetEntity =Ingredient.class)
    Ingredient ingredient;
    @Column(precision = 8, scale = 4)
    BigDecimal quantity;
}
