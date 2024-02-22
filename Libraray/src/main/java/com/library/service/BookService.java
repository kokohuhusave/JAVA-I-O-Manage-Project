package com.library.service;

import com.library.entity.Book;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BookService {
    Book saveBook(Book book);
    Optional<Book> findBookById(UUID id);
    List<Book> findAllBooks();
    Book updateBook(UUID id, Book bookDetails);
    void deleteBook(UUID id);
}
