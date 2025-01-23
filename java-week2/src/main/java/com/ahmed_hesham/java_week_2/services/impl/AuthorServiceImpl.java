package com.ahmed_hesham.java_week_2.services.impl;

import com.ahmed_hesham.java_week_2.dtos.AuthorDto;
import com.ahmed_hesham.java_week_2.entities.Author;
import com.ahmed_hesham.java_week_2.exceptions.BusinessException;
import com.ahmed_hesham.java_week_2.repositories.AuthorRepository;
import com.ahmed_hesham.java_week_2.services.AuthorService;
import jakarta.transaction.Transactional;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository repository;

    @Override
    public List<Author> allWithoutBooks() {
        return repository.findAllWithoutBooks();
    }

    @Transactional
    @Override
    public Author create(AuthorDto dto) {
        Author author = new Author();
        author.setName(dto.getName());
        repository.save(author);
        return author;
    }

    @Transactional
    @Override
    public Author update(Long id, AuthorDto dto) {
        Optional<Author> authorOptional = repository.findById(id);
        if (authorOptional.isEmpty()) throw new BusinessException("Author not found for id: " + id);
        Author author = authorOptional.get();
        author.setName(dto.getName());
        repository.save(author);
        return author;
    }

    @Override
    public Author show(Long id) {
        Optional<Author> authorOptional = repository.findById(id);
        if (authorOptional.isEmpty()) throw new BusinessException("Author not found for id: " + id);
        return authorOptional.get();
    }

    @Transactional
    @Override
    public void delete(Long id) {
        Optional<Author> authorOptional = repository.findById(id);
        if (authorOptional.isEmpty()) throw new BusinessException("Author not found for id: " + id);
        repository.delete(authorOptional.get());
    }
}
