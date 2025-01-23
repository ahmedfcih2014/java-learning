package com.ahmed_hesham.java_week_2.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class BookDto {
    @NotEmpty(message = "title field is required")
    @Size(
            min = 1,
            max = 150,
            message = "title min length is 1 character & max length is 150 characters"
    )
    private String title;

    private Double price;

    private Long authorId;

    private Long categoryId;
}
