package com.library.service;

import com.library.entity.Book; // 수정된 패키지
import com.library.repository.BookRepository; // 수정된 패키지
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // CRUD 메서드 구현 (생략)
}
