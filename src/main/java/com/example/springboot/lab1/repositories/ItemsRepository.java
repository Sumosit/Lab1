package com.example.springboot.lab1.repositories;

import com.example.springboot.lab1.entities.Items;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ItemsRepository extends JpaRepository<Items, Long> {

    Optional<Items> findById(Long id);

}