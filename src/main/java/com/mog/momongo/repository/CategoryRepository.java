package com.mog.momongo.repository;

import com.mog.momongo.entity.Category;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * CategoryRepository
 */
public interface CategoryRepository extends JpaRepository<Category, Long>{

    Category findByCategory(String category);
    
}