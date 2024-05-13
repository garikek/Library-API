package com.example.BookService.service;

import com.example.BookService.dto.BookDTO;
import com.example.BookService.dto.BookListDTO;
import com.example.BookService.mapper.BookMapper;
import lombok.RequiredArgsConstructor;
import com.example.BookService.model.Book;
import com.example.BookService.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    private BookMapper bookMapper;


    //Получение определённой книги по её Id
    public BookDTO getBookById(Long id) {
        Optional<Book> temp_book = bookRepository.findById(id);
        return bookMapper.toBookDTO(temp_book);
    }


    //Получение списка всех книг
    public BookListDTO getBooks() {
        return new BookListDTO(bookRepository.findAll().stream()
                .map((book) -> bookMapper.toBookDTO(Optional.ofNullable(book)))
                .collect(Collectors.toList()));
    }


    //Получение книги по её ISBN
    public BookDTO getBookByIsbn(String isbn) {
        Optional<Book> temp_book = bookRepository.findByIsbn(isbn);
        return bookMapper.toBookDTO(temp_book);
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
    public BookDTO addBook(BookDTO bookDTO) {
        Book book = bookMapper.toBookModel(bookDTO);
        Book savedBook = bookRepository.save(book);
        return bookMapper.toBookDTO(Optional.of(savedBook));
    }


}
