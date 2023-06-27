package com.nanoka.pasteleria.models;

import java.math.BigDecimal;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tasks")
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne(targetEntity = OrderDetail.class)
    @JoinColumn(name = "order_detail_id")
    OrderDetail orderDetail;
    @Column(precision = 8, scale = 4)
    BigDecimal quantity;
    @ManyToOne(targetEntity = UserEntity.class)
    UserEntity user;
    State state;
}
