package com.ahmed_hesham.java_week_2.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    @NotEmpty(message = "Title cannot be empty")
    private String title;

    @Column(nullable = false)
    @NotEmpty(message = "Author cannot be empty")
    private String author;

    @Column(name = "is_borrowed", nullable = false)
    private boolean isBorrowed = false;
}
