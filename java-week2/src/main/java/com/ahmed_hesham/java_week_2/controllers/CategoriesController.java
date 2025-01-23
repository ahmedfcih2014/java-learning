package com.ahmed_hesham.java_week_2.controllers;

import com.ahmed_hesham.java_week_2.dtos.CategoryDto;
import com.ahmed_hesham.java_week_2.dtos.CategoryResponseDto;
import com.ahmed_hesham.java_week_2.entities.Category;
import com.ahmed_hesham.java_week_2.responses.ApiResponse;
import com.ahmed_hesham.java_week_2.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoriesController {
    @Autowired
    private CategoryService service;

    @GetMapping
    public ApiResponse<List<Category>> all() {
        return ApiResponse.ok(service.allWithoutBooks());
    }

    @PostMapping
    public ApiResponse<CategoryResponseDto> create(@RequestBody @Valid CategoryDto dto) {
        Category category = service.create(dto);
        return ApiResponse.ok(
                CategoryResponseDto.builder()
                        .id(category.getId())
                        .title(category.getTitle())
                        .books(List.of())
                        .build()
        );
    }

    @PutMapping("/{id}")
    public ApiResponse<CategoryResponseDto> update(@PathVariable Long id, @RequestBody @Valid CategoryDto dto) {
        Category category = service.update(id, dto);
        return ApiResponse.ok(
                CategoryResponseDto.builder()
                        .id(category.getId())
                        .title(category.getTitle())
                        .books(List.of())
                        .build()
        );
    }

    @GetMapping("/{id}")
    public ApiResponse<CategoryResponseDto> show(@PathVariable Long id) {
        Category category = service.show(id);
        return ApiResponse.ok(
                CategoryResponseDto.builder()
                        .id(category.getId())
                        .title(category.getTitle())
                        .books(List.of())
                        .build()
        );
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> delete(@PathVariable Long id) {
        service.delete(id);
        return ApiResponse.ok("Category has been deleted");
    }
}
