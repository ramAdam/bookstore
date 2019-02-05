package com.mog.momongo.service;

import java.util.List;

import com.mog.momongo.entity.Author;
import com.mog.momongo.entity.Book;


public interface BookCrudServiceInterface{

    public void save(String title, String Category, String author);
    public void delete(Book book);
    public List<Book> findBookByAuthor(Author author); 
    public List<Book> findAll();
    public Book findByTitle(String title);
}