package com.example.BookService.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "book_inventory")
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "isbn", unique = true)
    private String isbn;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "genre")
    private String genre;

    @Column(name = "description")
    private String description;

    @Column(name = "author")
    private String author;
}
