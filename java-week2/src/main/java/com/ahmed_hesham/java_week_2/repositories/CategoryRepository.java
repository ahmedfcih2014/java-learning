package com.ahmed_hesham.java_week_2.repositories;

import com.ahmed_hesham.java_week_2.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query("SELECT new Category(c.id, c.title) FROM Category c")
    List<Category> findAllWithoutBooks();
}
