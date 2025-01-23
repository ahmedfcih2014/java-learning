package com.ahmed_hesham.java_week_2.dtos;

import com.ahmed_hesham.java_week_2.entities.Book;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryResponseDto {
    private Long id;
    private String title;
    private List<Book> books;
}
