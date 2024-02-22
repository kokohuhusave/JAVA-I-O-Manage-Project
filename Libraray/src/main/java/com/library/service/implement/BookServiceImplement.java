package com.library.service.implement;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.library.entity.Book;
import com.library.service.*;
import com.library.repository.*;

import lombok.RequiredArgsConstructor;


@Service
public class BookServiceImplement implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImplement(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Optional<Book> findBookById(UUID id) {
        return bookRepository.findById(id);
    }

    @Override
    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book updateBook(UUID id, Book bookDetails) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Book not found with id " + id));
        book.setTitle(bookDetails.getTitle());
        book.setAuthor(bookDetails.getAuthor());
        book.setPublicationDate(bookDetails.getPublicationDate());
        return bookRepository.save(book);
    }

    @Override
    public void deleteBook(UUID id) {
        bookRepository.deleteById(id);
    }
}