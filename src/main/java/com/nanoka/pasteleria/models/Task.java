package com.nanoka.pasteleria.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ingredient_inputs")
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String task;
    @ManyToOne(targetEntity = OrderDetail.class)
    @Column(name = "order_detail_id")
    OrderDetail orderDetail;
    @ManyToOne(targetEntity = UserEntity.class)
    UserEntity user;
    State state;
}
