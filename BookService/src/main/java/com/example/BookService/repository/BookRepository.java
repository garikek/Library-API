package com.example.BookService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.BookService.model.Book;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    @Query(value = "SELECT * FROM book_inventory WHERE book_isbn = ?1", nativeQuery = true)

    Optional<Book> findByIsbn(String isbn);
}
