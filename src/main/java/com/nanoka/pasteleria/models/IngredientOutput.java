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
@Table(name = "ingredient_outputs")
@FieldDefaults(level = AccessLevel.PRIVATE)

public class IngredientOutput {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;

    @CreationTimestamp
    LocalDateTime created_at;
    
    @UpdateTimestamp
    LocalDateTime updated_at;
}
