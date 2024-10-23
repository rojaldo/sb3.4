package com.example.demo.library.books;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRespository extends JpaRepository<BookEntity, Long> {

    Optional<BookEntity> findById(long id);
    Optional<BookEntity> findByIsbn(String isbn);
    List<BookEntity> findByPagesBetween(int pagesGT, int pagesLT);
    List<BookEntity> findByTitleContainingIgnoreCase(String title);
    List<BookEntity> findByTitleContainingIgnoreCaseAndPagesBetween(String title, int pagesGT, int pagesLT);
    List<BookEntity> findByAuthorContainingIgnoreCase(String author);
    List<BookEntity> findByAuthorContainingIgnoreCaseAndPagesBetween(String author, int pagesGT, int pagesLT);
    BookEntity findByAuthorAndTitleIgnoreCase(String author, String title);
    BookEntity findByAuthorAndTitleIgnoreCaseAndPagesBetween(String author, String title, int pagesGT, int pagesLT);

}
