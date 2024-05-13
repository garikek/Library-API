package com.example.BookService.mapper;

import com.example.BookService.dto.BookDTO;
import com.example.BookService.model.Book;
import org.mapstruct.Mapper;

import java.util.Optional;

@Mapper(componentModel = "spring")
public interface BookMapper {
    BookDTO toBookDTO(Optional<Book> book);
    Book toBookModel(BookDTO bookDTO);
}