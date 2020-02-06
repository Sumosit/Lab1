package com.example.springboot.lab1.controllers;

import com.example.springboot.lab1.entities.Categories;
import com.example.springboot.lab1.repositories.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CategoriesController {

    @Autowired
    private CategoriesRepository categoriesRepository;

    @GetMapping(value = "/categories")
    public String Categories(ModelMap model) {
        List<Categories> categories = categoriesRepository.findAll();

        model.addAttribute("categories", categories);

        return "category.html";
    }
    @GetMapping(value = "/editCategory")
    public String editCategory(ModelMap model,
                               @RequestParam(name = "id_category") Long id_category) {

        Categories category = categoriesRepository.getOne(id_category);

        model.addAttribute("category", category);

        return "editCategory.html";
    }
    @PostMapping(value = "/editCategory")
    public String editCategory(
            @RequestParam(name = "id_category") Long id_category,
            @RequestParam(name = "name") String name) {

        Categories category = categoriesRepository.getOne(id_category);
        category.setName(name);
        categoriesRepository.save(category);

        return "redirect:/categories";
    }
    @PostMapping(value = "/addCategory")
    public String addCategory(
            @RequestParam(name = "name") String name) {

        Categories category = new Categories(null, name);
        categoriesRepository.save(category);

        return "redirect:/categories";
    }
}