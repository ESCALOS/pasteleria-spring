package com.nanoka.pasteleria.models;

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
@Table(name = "ingredient_inputs")
@FieldDefaults(level = AccessLevel.PRIVATE)

public class IngredientInput {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;

    @CreationTimestamp
    @Column(name = "created_at")
    LocalDateTime createdAt;
    
    @UpdateTimestamp
    @Column(name = "created_at")
    LocalDateTime updatedAt;
}
