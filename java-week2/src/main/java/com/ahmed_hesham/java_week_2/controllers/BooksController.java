package com.ahmed_hesham.java_week_2.controllers;

import com.ahmed_hesham.java_week_2.dtos.BookDto;
import com.ahmed_hesham.java_week_2.entities.Book;
import com.ahmed_hesham.java_week_2.responses.ApiResponse;
import com.ahmed_hesham.java_week_2.responses.MessageResponse;
import com.ahmed_hesham.java_week_2.services.BooksService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
    public ApiResponse<MessageResponse> addBook(
            @RequestBody @Valid BookDto dto
    ) {
        return ApiResponse.ok(service.addBook(dto));
    }

    @GetMapping("/search")
    public List<Book> getBooksByCategory(@RequestParam String categoryName) {
        return service.booksByCategory(categoryName);
    }

    @GetMapping("/paginate")
    public Page<Book> getBooksPaginated(@RequestParam int page, @RequestParam int size) {
        return service.booksPaginated(page, size);
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
