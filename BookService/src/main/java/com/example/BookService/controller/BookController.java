package com.example.BookService.controller;

import com.example.BookService.model.Book;
import com.example.BookService.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;


    //Получение списка всех книг
    @GetMapping
    public List<Book> getBooks() {
        return bookService.getBooks();
    }


    //Получение определённой книги по её id
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBook(@RequestParam(name = "id") long id) {
        Book book = bookService.getBook(id);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }


    //Получение книги по её ISBN
    @GetMapping("/{isbn}")
    public ResponseEntity<Book> getBook(@RequestParam(name = "isbn") String isbn) {
        Book book = bookService.getBookByIsbn(isbn);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }


    //Добавление новой книги
    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        Book savedBook = bookService.addBook(book);
        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }


    //Изменение информации о существующей книге
    @PatchMapping
    public ResponseEntity<Book> updateBook(@RequestParam(name ="id") long id, @RequestBody Book book) {
        Book updatedBook = bookService.updateBook(id, book);
        return new ResponseEntity<>(updatedBook, HttpStatus.OK);
    }


    //Удаление книги
    @DeleteMapping
    public ResponseEntity<Book> deleteBook(@RequestParam(name ="id") long id) {
        Book deletedBook = bookService.deleteBook(id);
        return new ResponseEntity<>(deletedBook, HttpStatus.OK);
    }

}
