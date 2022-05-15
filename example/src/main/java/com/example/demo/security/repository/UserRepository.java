package com.example.demo.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.security.model.User;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
