package com.tedaneblake.ankirestapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tedaneblake.ankirestapi.models.User;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(@Param("username") String username);

    Optional<User> findByEmail(@Param("email") String email);

}
