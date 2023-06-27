package com.nanoka.pasteleria.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ingredients")
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    
    @ManyToOne(targetEntity = MeasurementUnit.class)
    MeasurementUnit measurementUnit;
}
