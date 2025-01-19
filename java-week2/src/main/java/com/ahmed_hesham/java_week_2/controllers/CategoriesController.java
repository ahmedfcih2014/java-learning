package com.ahmed_hesham.java_week_2.controllers;

import com.ahmed_hesham.java_week_2.entities.Category;
import com.ahmed_hesham.java_week_2.repositories.CategoryRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoriesController {
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping
    public List<Category> allCategories() {
        return categoryRepository.findAllWithoutBooks();
    }

    @PostMapping
    public Category createCategory(@RequestBody @Valid Category category) {
        return categoryRepository.save(category);
    }
}
