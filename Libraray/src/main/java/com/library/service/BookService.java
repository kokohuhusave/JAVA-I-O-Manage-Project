package com.library.service;

<<<<<<< HEAD
import com.library.entity.Book;
=======
import com.library.entity.Book; 
import com.library.repository.BookRepository; 
import org.springframework.stereotype.Service;

>>>>>>> 958b6aadda1776cb619bd4d4260ebd5d927976d4
import java.util.List;
import java.util.Optional;
import java.util.UUID;

<<<<<<< HEAD
public interface BookService {
    Book saveBook(Book book);
    Optional<Book> findBookById(UUID id);
    List<Book> findAllBooks();
    Book updateBook(UUID id, Book bookDetails);
    void deleteBook(UUID id);
=======
@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    
>>>>>>> 958b6aadda1776cb619bd4d4260ebd5d927976d4
}
