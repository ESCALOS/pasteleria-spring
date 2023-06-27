package com.nanoka.pasteleria.models;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "measurement_units")
public class MeasurementUnit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String abbreviation;

    @OneToMany(targetEntity = Ingredient.class, fetch = FetchType.LAZY, mappedBy = "measurementUnit")
    private List<Ingredient> ingredients;
}
