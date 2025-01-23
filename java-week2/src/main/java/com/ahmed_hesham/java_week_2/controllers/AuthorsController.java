package com.ahmed_hesham.java_week_2.controllers;

import com.ahmed_hesham.java_week_2.dtos.AuthorDto;
import com.ahmed_hesham.java_week_2.dtos.AuthorResponseDto;
import com.ahmed_hesham.java_week_2.entities.Author;
import com.ahmed_hesham.java_week_2.responses.ApiResponse;
import com.ahmed_hesham.java_week_2.services.AuthorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
@RequiredArgsConstructor
public class AuthorsController {
    private final AuthorService service;

    @GetMapping
    public ApiResponse<List<Author>> all() {
        return ApiResponse.ok(service.allWithoutBooks());
    }

    @PostMapping
    public ApiResponse<AuthorResponseDto> create(@RequestBody @Valid AuthorDto dto) {
        Author author = service.create(dto);
        return ApiResponse.ok(
                AuthorResponseDto.builder()
                        .id(author.getId())
                        .name(author.getName())
                        .books(List.of())
                        .build()
        );
    }

    @PutMapping("/{id}")
    public ApiResponse<AuthorResponseDto> update(@PathVariable Long id, @RequestBody @Valid AuthorDto dto) {
        Author author = service.update(id, dto);
        return ApiResponse.ok(
                AuthorResponseDto.builder()
                        .id(author.getId())
                        .name(author.getName())
                        .books(List.of())
                        .build()
        );
    }

    @GetMapping("/{id}")
    public ApiResponse<AuthorResponseDto> show(@PathVariable Long id) {
        Author author = service.show(id);
        return ApiResponse.ok(
                AuthorResponseDto.builder()
                        .id(author.getId())
                        .name(author.getName())
                        .books(List.of())
                        .build()
        );
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> delete(@PathVariable Long id) {
        service.delete(id);
        return ApiResponse.ok("Author has been deleted");
    }
}
