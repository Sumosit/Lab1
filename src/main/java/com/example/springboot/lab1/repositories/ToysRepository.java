package com.example.springboot.lab1.repositories;

import com.example.springboot.lab1.entities.Toys;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ToysRepository extends JpaRepository<Toys, Long> {

    Optional<Toys> findById(Long id);
}
