package com.library.repository;

import com.library.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface BookRepository extends JpaRepository<Book, UUID> {
    // 필요한 추가 쿼리 메서드를 여기에 정의할 수 있습니다
}
