package com.example.springboot.lab1.controllers;

import com.example.springboot.lab1.entities.Courses;
import com.example.springboot.lab1.repositories.CoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CoursesController {

    @Autowired
    CoursesRepository coursesRepository;

    @GetMapping(value = "/courses")
    public String Courses(ModelMap model) {
        List<Courses> courses = coursesRepository.findAll();

        model.addAttribute("courses", courses);

        return "courses.html";
    }
    @PostMapping(value = "/addCourse")
    public String addCourse(
            @RequestParam(name = "name") String name,
            @RequestParam(name = "credits") int credits) {
        Courses courses = new Courses(null, name, credits);
        coursesRepository.save(courses);

        return "redirect:/courses";
    }
    @GetMapping(value = "/editCourse")
    public String editCourse (
            ModelMap model,
            @RequestParam(name = "id") Long id) {
        Courses course = coursesRepository.getOne(id);

        model.addAttribute("course", course);

        return "editCourse.html";
    }
    @PostMapping(value = "/editCourse")
    public String editCourse (
            @RequestParam(name = "id") Long id,
            @RequestParam(name = "name") String name,
            @RequestParam(name = "credits") int credits) {
        Courses course = coursesRepository.getOne(id);
        course.setName(name);
        course.setCredits(credits);
        coursesRepository.save(course);
        return "redirect:/courses";
    }
}
