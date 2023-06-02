package com.nanoka.pasteleria.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nanoka.pasteleria.models.UserEntity;

public interface IUserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByUsername(String username);

    Boolean existsByUsername(String username);

}