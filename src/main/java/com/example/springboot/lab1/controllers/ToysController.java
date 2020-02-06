package com.example.springboot.lab1.controllers;

import com.example.springboot.lab1.entities.Categories;
import com.example.springboot.lab1.entities.Toys;
import com.example.springboot.lab1.repositories.CategoriesRepository;
import com.example.springboot.lab1.repositories.ToysRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class ToysController {

    @Autowired
    private ToysRepository toysRepository;

    @Autowired
    private CategoriesRepository categoriesRepository;

    @GetMapping(value = "/toys")
    public String Toys(ModelMap model) {
        List<Toys> toys = toysRepository.findAll();
        List<Categories> categories = categoriesRepository.findAll();
        double total = 0;
        for (Toys c : toys) {
            total = total + c.getPrice();
        }

        model.addAttribute("editStatus", 0);
        model.addAttribute("toys", toys);
        model.addAttribute("categories", categories);
        model.addAttribute("total", (float)total);

        return "toys.html";
    }
    @GetMapping(value = "/editToy")
    public String editToy(ModelMap model,
                          @RequestParam(name = "id") Long id) {
        List<Toys> toys = toysRepository.findAll();
        List<Categories> categories = categoriesRepository.findAll();
        double total = 0;
        for (Toys c : toys) {
            total = total + c.getPrice();
        }

        model.addAttribute("editStatus", id);
        model.addAttribute("toys", toys);
        model.addAttribute("categories", categories);
        model.addAttribute("total", (float)total);

        return "toys.html";
    }

    @PostMapping(value = "addToy")
    public String addToy(
            @RequestParam(name = "name") String name,
            @RequestParam(name = "category") Long id_category,
            @RequestParam(name = "price") double price) {
        Categories category = new Categories();
        category.setId(id_category);
        Toys toy = new Toys(null, name, price, category);
        toysRepository.save(toy);

        return "redirect:/toys";
    }

    @PostMapping(value = "editToy")
    public String editToy(
            @RequestParam(name = "id") Long id,
            @RequestParam(name = "name") String name,
            @RequestParam(name = "category") Long id_category,
            @RequestParam(name = "price") double price) {

        Categories category = new Categories();
        category.setId(id_category);
        Toys toy = toysRepository.getOne(id);
        toy.setName(name);
        toy.setCategories(category);
        toy.setPrice(price);
        toysRepository.save(toy);

        return "redirect:/toys";
    }
}
