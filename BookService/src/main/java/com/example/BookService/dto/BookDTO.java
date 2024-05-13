package com.example.BookService.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookDTO {
    private Long id;
    private String isbn;
    private String title;
    private String genre;
    private String author;
    private String description;
}
