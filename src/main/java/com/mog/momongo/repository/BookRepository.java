package com.mog.momongo.repository;

import java.util.List;
import com.mog.momongo.entity.Author;
import com.mog.momongo.entity.Book;

import org.springframework.data.repository.CrudRepository;





/**
 * BookReadingRepository
 */
public interface BookRepository extends CrudRepository<Book, Long>{

    List<Book> findByAuthors(Author author);
    List<Book> findAll();
    Book findByTitle(String title);
    Book findBookByTitleStartsWithIgnoreCase(String title);
    
}