package com.mog.momongo.repository;

import java.util.Collection;

import com.mog.momongo.entity.Author;
import com.mog.momongo.entity.Book;

import org.springframework.data.jpa.repository.JpaRepository;


/**
 * AuthorRepository
 */
public interface AuthorRepository extends JpaRepository<Author, Long>{

    Collection<Author> findByBooks(Book book);
    
}