package com.school.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.entity.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Optional<String> findByPassword(String Password);
    Boolean existsByUsername(String username);
    Boolean existsByDni(Long dni);
    User findByDni(Long dni);
    User findByUsernameAndPassword(String username, String password);
}