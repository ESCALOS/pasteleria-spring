package com.nanoka.pasteleria.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ingredient_outputs")
@FieldDefaults(level = AccessLevel.PRIVATE)

public class IngredientOutput {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne(targetEntity = Task.class)
    Task task;
    @ManyToOne(targetEntity = Ingredient.class)
    Ingredient ingredient;
    @Column(precision = 8, scale = 4)
    BigDecimal quantity;
    @Column(precision = 8, scale = 4)
    BigDecimal price;
    @CreationTimestamp
    @Column(name = "created_at")
    LocalDateTime createdAt;
    @UpdateTimestamp
    @Column(name = "updated_at")
    LocalDateTime updatedAt;
}
