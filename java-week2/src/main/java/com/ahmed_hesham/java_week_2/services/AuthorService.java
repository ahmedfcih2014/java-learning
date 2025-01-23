package com.ahmed_hesham.java_week_2.services;

import com.ahmed_hesham.java_week_2.dtos.AuthorDto;
import com.ahmed_hesham.java_week_2.entities.Author;

import java.util.List;

public interface AuthorService {
    List<Author> allWithoutBooks();
    Author create(AuthorDto dto);
    Author update(Long id, AuthorDto dto);
    Author show(Long id);
    void delete(Long id);
}
