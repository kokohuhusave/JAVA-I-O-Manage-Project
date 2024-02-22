package com.library.Controller; 

import com.library.entity.Book; 
import com.library.service.BookService; 
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.findAllBooks();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable UUID id) {
        return bookService.findBookById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found with id " + id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book createBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable UUID id, @RequestBody Book bookDetails) {
        return bookService.updateBook(id, bookDetails);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable UUID id) {
        bookService.deleteBook(id);
    }
}