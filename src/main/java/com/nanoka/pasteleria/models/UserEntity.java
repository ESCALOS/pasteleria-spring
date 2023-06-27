package com.nanoka.pasteleria.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
@FieldDefaults(level = AccessLevel.PRIVATE)

public class UserEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    Long id;
    String username;
    String password;
    String name;
    Boolean enabled = true;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), 
    inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    List<Role> roles = new ArrayList<>();
}