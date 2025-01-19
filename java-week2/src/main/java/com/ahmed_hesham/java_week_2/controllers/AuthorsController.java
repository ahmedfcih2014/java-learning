package com.ahmed_hesham.java_week_2.controllers;

import com.ahmed_hesham.java_week_2.entities.Author;
import com.ahmed_hesham.java_week_2.repositories.AuthorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
public class AuthorsController {
    @Autowired
    private AuthorRepository authorRepository;

    @GetMapping
    public List<Author> allAuthors() {
        return authorRepository.findAllWithoutBooks();
    }

    @PostMapping
    public Author createAuthor(@RequestBody @Valid Author author) {
        return authorRepository.save(author);
    }
}
