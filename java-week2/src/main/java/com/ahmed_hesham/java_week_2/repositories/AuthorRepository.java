package com.ahmed_hesham.java_week_2.repositories;

import com.ahmed_hesham.java_week_2.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    @Query("SELECT new Author(c.id, c.name) FROM Author c")
    List<Author> findAllWithoutBooks();
}
