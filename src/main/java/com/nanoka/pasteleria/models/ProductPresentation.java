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

public class ProductPresentation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne(targetEntity = Product.class)
    Product product;
    String presentation;
    @Column(precision = 8, scale = 4)
    BigDecimal price;
    
}
