package com.ahmed_hesham.java_week_2.services;

import com.ahmed_hesham.java_week_2.dtos.BookDto;
import com.ahmed_hesham.java_week_2.entities.Author;
import com.ahmed_hesham.java_week_2.entities.Book;
import com.ahmed_hesham.java_week_2.entities.Category;
import com.ahmed_hesham.java_week_2.exceptions.BusinessException;
import com.ahmed_hesham.java_week_2.repositories.AuthorRepository;
import com.ahmed_hesham.java_week_2.repositories.BookRepository;
import com.ahmed_hesham.java_week_2.repositories.CategoryRepository;
import com.ahmed_hesham.java_week_2.responses.MessageResponse;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BooksService {
    @Autowired
    private BookRepository repository;
    private AuthorRepository authorRepository;
    private CategoryRepository categoryRepository;

    public List<Book> allBooks() {
        return repository.findAll();
    }

    public List<Book> booksByCategory(String categoryName) {
        return repository.findByCategoryTitle(categoryName);
    }

    public Page<Book> booksPaginated(int page, int size) {
        return repository.findAll(PageRequest.of(page, size));
    }

    public MessageResponse addBook(BookDto dto) throws ValidationException {
        Optional<Author> author = authorRepository.findById(dto.getAuthorId());
        if(author.isEmpty()) throw new ValidationException("Author not found");

        Optional<Category> category = categoryRepository.findById(dto.getCategoryId());
        if(category.isEmpty()) throw new ValidationException("Category not found");

        Book b = new Book();
        b.setTitle(dto.getTitle());
        b.setPrice(dto.getPrice());
        b.setAuthor(author.get());
        b.setCategory(category.get());
        repository.save(b);
        return MessageResponse.builder().message("%s created".formatted(dto.getTitle())).build();
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
