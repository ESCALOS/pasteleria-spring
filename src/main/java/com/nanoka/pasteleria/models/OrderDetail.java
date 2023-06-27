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

public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne(targetEntity = Order.class)
    Order order;
    @ManyToOne(targetEntity = ProductPresentation.class)
    ProductPresentation productPresentation;
    @Column(precision = 8, scale = 4)
    BigDecimal quantity;
    @Column(name = "dispatched_quantity",precision = 8, scale = 4)
    BigDecimal dispatchedQuantity = BigDecimal.ZERO;
    @Column(precision = 8, scale = 4)
    BigDecimal price;
    String detail;
}
