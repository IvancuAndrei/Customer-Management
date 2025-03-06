package com.customerapp.customer_management_backend.repository;

import com.customerapp.customer_management_backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {


   Optional<User> findById(Long id);

    Optional<User> findByUsername(String username);

    User findByEmail(String email);

}
