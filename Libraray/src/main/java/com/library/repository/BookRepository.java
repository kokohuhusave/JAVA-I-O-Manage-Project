package com.library.repository;

import com.library.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface BookRepository extends JpaRepository<Book, UUID> {
    
}
