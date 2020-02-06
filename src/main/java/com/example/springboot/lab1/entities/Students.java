package com.example.springboot.lab1.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "students")
public class Students {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "yearOfAddmission")
    private int yearOfAddmission;

    @ManyToMany(fetch = FetchType.LAZY)
    Set<Courses> courses;

    @ManyToMany(fetch = FetchType.LAZY)
    Set<Groups> groups;
}
