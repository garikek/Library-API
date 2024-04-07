package com.example.BookService.service;

import com.example.BookService.model.Book;
import com.example.BookService.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;


    //Получение определённой книги по её Id
    public Book getBook(long Id) {
        return bookRepository.findById(Id).orElseThrow(() -> new RuntimeException("Not Found"));
    }


    //Получение списка всех книг
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }


    //Получение книги по её ISBN
    public Book getBookByIsbn(String isbn) {
        return bookRepository.getBookByIsbn(isbn);
    }


    //Удаление книги
    public Book deleteBook(long id) {
        Book existingBook = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));
        bookRepository.deleteById(id);
        return existingBook;
    }


    //Изменение информации о существующей книге
    public Book updateBook(long id, Book book) {
        Book existingBook = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));
        existingBook.setIsbn(book.getIsbn());
        existingBook.setTitle(book.getTitle());
        existingBook.setGenre(book.getGenre());
        existingBook.setDescription(book.getDescription());
        existingBook.setAuthor(book.getAuthor());
        bookRepository.save(existingBook);
        return existingBook;
    }


    //Добавление новой книги
    public Book addBook(Book book){
        return bookRepository.save(book);
    }


}
