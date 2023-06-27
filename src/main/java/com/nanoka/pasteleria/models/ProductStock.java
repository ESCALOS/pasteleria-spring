package com.nanoka.pasteleria.models;

import java.math.BigDecimal;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
@FieldDefaults(level = AccessLevel.PRIVATE)

public class ProductStock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne(targetEntity = Product.class)
    ProductPresentation productPresentation;
    @Column(precision = 8, scale = 4)
    BigDecimal quantity;
    @Column(precision = 8, scale = 4)
    BigDecimal price;
}
