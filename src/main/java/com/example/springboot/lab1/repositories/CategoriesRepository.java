package com.example.springboot.lab1.repositories;

import com.example.springboot.lab1.entities.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoriesRepository extends JpaRepository<Categories, Long> {

    Optional<Categories> findById(Long id);
}
