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
@Table(name = "products")
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne(targetEntity = Client.class)
    Client client;
    @ManyToOne(targetEntity = UserEntity.class)
    UserEntity user;
    String address;
    @Column(name = "home_delivery")
    Boolean homeDelivery = false;
    @Column(name = "total_price")
    BigDecimal totalPrice;
    @Column(name = "amount_paid")
    BigDecimal amountPaid;
    @Enumerated(EnumType.STRING)
    State state;
    @CreationTimestamp
    @Column(name = "created_at")
    LocalDateTime createdAt;
    @Column(name = "updated_at")
    LocalDateTime updatedAt;
}
