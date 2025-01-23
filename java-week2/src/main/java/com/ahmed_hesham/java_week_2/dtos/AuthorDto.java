package com.ahmed_hesham.java_week_2.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AuthorDto {
    @NotEmpty(message = "Name cannot be empty")
    @Size(min = 2, max = 50, message = "Name length must be between 2 to 50 characters")
    private String name;
}
