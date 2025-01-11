package com.ahmed_hesham.java_week_2.services;

import com.ahmed_hesham.java_week_2.dtos.BookDto;
import com.ahmed_hesham.java_week_2.entities.Book;
import com.ahmed_hesham.java_week_2.repositories.BookRepository;
import com.ahmed_hesham.java_week_2.responses.BookResponse;
import com.ahmed_hesham.java_week_2.responses.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksService {
    @Autowired
    private BookRepository repository;

    public List<Book> allBooks() {
        return List.of();
    }

    public BookResponse addBook(BookDto dto) throws Exception {
        throw new Exception("Can`t add book for current time");
//        return new BookResponse(1L, dto.getTitle(), dto.getAuthor());
    }

    public MessageResponse borrowBook(Long id) {
        return MessageResponse.builder().message("Book borrowed successfully").build();
    }

    public MessageResponse returnBook(Long id) {
        return MessageResponse.builder().message("Book returned successfully").build();
    }
}
