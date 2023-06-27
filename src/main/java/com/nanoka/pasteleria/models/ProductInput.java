package com.nanoka.pasteleria.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product_inputs")
@FieldDefaults(level = AccessLevel.PRIVATE)

public class ProductInput {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne(targetEntity = Task.class)
    Task task;
    @ManyToOne(targetEntity = ProductStock.class)
    @JoinColumn(name = "product_stock_id")
    ProductStock productStock;
    @Column(precision = 8, scale = 4)
    BigDecimal quantity;
    @Column(precision = 8, scale = 4)
    BigDecimal price;
    @CreationTimestamp
    @Column(name = "created_at")
    LocalDateTime createdAt;
    @Column(name = "updated_at")
    LocalDateTime updatedAt;
}