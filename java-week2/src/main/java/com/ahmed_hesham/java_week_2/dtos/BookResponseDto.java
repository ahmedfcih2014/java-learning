package com.ahmed_hesham.java_week_2.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookResponseDto {
    private Long id;
    private String title;
    private Double price;
    private boolean isBorrowed;
    private String authorName;
    private String categoryTitle;
}

