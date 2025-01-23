package com.ahmed_hesham.java_week_2.repositories;

import com.ahmed_hesham.java_week_2.entities.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByCategoryTitle(String categoryTitle);

    @Query("SELECT b FROM Book b WHERE b.author.name = :authorName")
    List<Book> findBooksByAuthor(@Param("authorName") String authorName);

    @Query(value = "SELECT DISTINCT b FROM Book b JOIN FETCH b.author JOIN FETCH b.category",
            countQuery = "SELECT COUNT(b) FROM Book b")
    Page<Book> findAll(Pageable pageable);
}
