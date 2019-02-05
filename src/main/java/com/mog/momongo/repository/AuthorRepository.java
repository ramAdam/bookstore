package com.mog.momongo.repository;

import com.mog.momongo.entity.Author;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * AuthorRepository
 */
public interface AuthorRepository extends JpaRepository<Author, Long>{

    
}