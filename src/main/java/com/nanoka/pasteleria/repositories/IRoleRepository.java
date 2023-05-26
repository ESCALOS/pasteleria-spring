package com.nanoka.pasteleria.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nanoka.pasteleria.models.Role;

public interface IRoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
}