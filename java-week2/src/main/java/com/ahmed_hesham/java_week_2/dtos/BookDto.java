package com.ahmed_hesham.java_week_2.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class BookDto {
    @NotEmpty(message = "Title field is required")
    @Size(
            min = 1,
            max = 150,
            message = "Title min length is 1 character & max length is 150 characters"
    )
    private String title;

    @NotEmpty(message = "Author field is required")
    @Size(
            min = 1,
            max = 150,
            message = "Author min length is 1 character & max length is 150 characters"
    )
    private String author;
}
