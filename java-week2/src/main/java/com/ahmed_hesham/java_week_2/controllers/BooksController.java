package com.ahmed_hesham.java_week_2.controllers;

import com.ahmed_hesham.java_week_2.dtos.BookDto;
import com.ahmed_hesham.java_week_2.entities.Book;
import com.ahmed_hesham.java_week_2.responses.ApiResponse;
import com.ahmed_hesham.java_week_2.responses.BookResponse;
import com.ahmed_hesham.java_week_2.responses.MessageResponse;
import com.ahmed_hesham.java_week_2.services.BooksService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BooksController {
    @Autowired
    private BooksService service;

    @GetMapping()
    public ApiResponse<List<Book>> allBooks() {
        return ApiResponse.ok(service.allBooks());
    }

    @PostMapping()
    public ApiResponse<BookResponse> addBook(
            @RequestBody @Valid BookDto dto
    ) throws Exception {
        return ApiResponse.ok(service.addBook(dto));
    }

    @PutMapping("/{id}/borrow")
    public ApiResponse<MessageResponse> borrowBook(
            @PathVariable Long id
    ) {
        return ApiResponse.ok(service.borrowBook(id));
    }

    @PutMapping("/{id}/return")
    public ApiResponse<MessageResponse> returnBook(
            @PathVariable Long id
    ) {
        return ApiResponse.ok(service.returnBook(id));
    }
}
