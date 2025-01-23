package com.ahmed_hesham.java_week_2.services.impl;

import com.ahmed_hesham.java_week_2.dtos.CategoryDto;
import com.ahmed_hesham.java_week_2.entities.Category;
import com.ahmed_hesham.java_week_2.exceptions.BusinessException;
import com.ahmed_hesham.java_week_2.repositories.CategoryRepository;
import com.ahmed_hesham.java_week_2.services.CategoryService;
import jakarta.transaction.Transactional;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository repository;

    @Override
    public List<Category> allWithoutBooks() {
        return repository.findAllWithoutBooks();
    }

    @Transactional
    @Override
    public Category create(CategoryDto dto) {
        Category c = new Category();
        c.setTitle(dto.getTitle());
        repository.save(c);
        return c;
    }

    @Transactional
    @Override
    public Category update(Long id, CategoryDto dto) {
        Optional<Category> categoryOptional = repository.findById(id);
        if (categoryOptional.isEmpty()) throw new BusinessException("Category not found for id: " + id);
        Category c = categoryOptional.get();
        c.setTitle(dto.getTitle());
        repository.save(c);
        return c;
    }

    @Override
    public Category show(Long id) {
        Optional<Category> categoryOptional = repository.findById(id);
        if (categoryOptional.isEmpty()) throw new BusinessException("Category not found for id: " + id);
        return categoryOptional.get();
    }

    @Transactional
    @Override
    public void delete(Long id) {
        Optional<Category> categoryOptional = repository.findById(id);
        if (categoryOptional.isEmpty()) throw new BusinessException("Category not found for id: " + id);
        repository.delete(categoryOptional.get());
    }
}
