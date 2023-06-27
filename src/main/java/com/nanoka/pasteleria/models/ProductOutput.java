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
@Table(name = "product_outputs")
@FieldDefaults(level = AccessLevel.PRIVATE)

public class ProductOutput {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne(targetEntity = OrderDetail.class)
    @JoinColumn(name = "order_detail_id")
    OrderDetail orderDetail;
    @ManyToOne(targetEntity = ProductStock.class)
    @JoinColumn(name = "product_stock_id")
    ProductStock productStock;
    @Column(precision = 8, scale = 4)
    BigDecimal quantity;
    @Column(precision = 8, scale = 4)
    BigDecimal price;
    @ManyToOne(targetEntity = UserEntity.class)
    UserEntity user;
    @ManyToOne(targetEntity = Client.class)
    Client client;
    @CreationTimestamp
    @Column(name = "created_at")
    LocalDateTime createdAt;
    @Column(name = "updated_at")
    LocalDateTime updatedAt;
}
