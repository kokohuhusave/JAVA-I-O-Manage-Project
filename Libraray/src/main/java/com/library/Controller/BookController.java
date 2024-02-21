package com.library.Controller; // 'controller'를 소문자로

import com.library.entity.Book; // 수정된 패키지
import com.library.service.BookService; // 수정된 패키지
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // CRUD 엔드포인트 구현 (생략)
}
