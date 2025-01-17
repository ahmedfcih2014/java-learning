package com.ahmed_hesham.java_week_2.services;

import com.ahmed_hesham.java_week_2.dtos.BookDto;
import com.ahmed_hesham.java_week_2.entities.Book;
import com.ahmed_hesham.java_week_2.exceptions.BusinessException;
import com.ahmed_hesham.java_week_2.repositories.BookRepository;
import com.ahmed_hesham.java_week_2.responses.BookResponse;
import com.ahmed_hesham.java_week_2.responses.MessageResponse;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BooksService {
    @Autowired
    private BookRepository repository;

    public List<Book> allBooks() {
        return repository.findAll();
    }

    public BookResponse addBook(BookDto dto) {
        Book b = new Book();
        b.setTitle(dto.getTitle());
        b.setAuthor(dto.getAuthor());
        repository.save(b);
        return BookResponse.builder().id(b.getId()).title(b.getTitle()).author(b.getAuthor()).build();
    }

    public MessageResponse borrowBook(Long id) {
        Optional<Book> optionalBook = repository.findById(id);
        if (optionalBook.isEmpty()) throw new EntityNotFoundException("You trying to reach not found book");
        Book b = optionalBook.get();
        if (b.isBorrowed()) throw new BusinessException("Book is already borrowed, you can`t borrow it");
        b.setBorrowed(true);
        repository.save(b);
        return MessageResponse.builder().message("Book borrowed successfully").build();
    }

    public MessageResponse returnBook(Long id) {
        Optional<Book> optionalBook = repository.findById(id);
        if (optionalBook.isEmpty()) throw new EntityNotFoundException("You trying to reach not found book");
        Book b = optionalBook.get();
        if (!b.isBorrowed()) throw new BusinessException("Book is already returned, you can`t return it");
        b.setBorrowed(false);
        repository.save(b);
        return MessageResponse.builder().message("Book returned successfully").build();
    }
}
