package com.company.NeuroCity.Auth_Service.repository;

import com.company.NeuroCity.Auth_Service.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface  UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);
    Optional<User> findById(Long id);

}