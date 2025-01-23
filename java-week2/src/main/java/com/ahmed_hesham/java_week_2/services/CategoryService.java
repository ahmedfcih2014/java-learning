package com.ahmed_hesham.java_week_2.services;

import com.ahmed_hesham.java_week_2.dtos.CategoryDto;
import com.ahmed_hesham.java_week_2.entities.Category;

import java.util.List;

public interface CategoryService {
    List<Category> allWithoutBooks();
    Category create(CategoryDto dto);
    Category update(Long id, CategoryDto dto);
    Category show(Long id);
    void delete(Long id);
}
