package com.example.BookService.controller;


import com.example.BookService.dto.BookDTO;
import com.example.BookService.dto.BookListDTO;
import com.example.BookService.model.Book;
import com.example.BookService.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequiredArgsConstructor
@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;


    //Получение списка всех книг
    @GetMapping
    public ResponseEntity<BookListDTO> getBooks() {
        return ResponseEntity.ok().body(bookService.getBooks());
    }

    //-------------------
    //Получение определённой книги по её id
    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> getBookById(@PathVariable Long id) {
        return ResponseEntity.ok().body(bookService.getBookById(id));
    }


    //Получение книги по её ISBN
    @GetMapping("/{isbn}")
    public ResponseEntity<BookDTO> getBookByIsbn(@PathVariable String isbn) {
        return ResponseEntity.ok().body(bookService.getBookByIsbn(isbn));
    }


    //Добавление новой книги
    @PostMapping
    public void addBook(@RequestBody BookDTO bookDTO) {
        bookService.addBook(bookDTO);
    }


    //Изменение информации о существующей книге
    @PatchMapping
    public ResponseEntity<Book> updateBook(@RequestParam(name ="id") long id, @RequestBody Book book) {
        Book updatedBook = bookService.updateBook(id, book);
        return new ResponseEntity<>(updatedBook, HttpStatus.OK);
    }


    //Удаление книги
    @DeleteMapping("/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable Long id) {
        Book deletedBook = bookService.deleteBook(id);
        return new ResponseEntity<>(deletedBook, HttpStatus.OK);
    }

}
