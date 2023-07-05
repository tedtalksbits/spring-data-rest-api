package com.tedaneblake.ankirestapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tedaneblake.ankirestapi.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
