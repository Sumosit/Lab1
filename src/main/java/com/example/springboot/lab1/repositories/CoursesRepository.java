package com.example.springboot.lab1.repositories;

import com.example.springboot.lab1.entities.Categories;
import com.example.springboot.lab1.entities.Courses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoursesRepository extends JpaRepository<Courses, Long> {

}
