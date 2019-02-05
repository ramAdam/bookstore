package com.mog.momongo.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * Author
 */
@Entity
public class Author {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToMany(mappedBy="authors", fetch=FetchType.EAGER)
    private Set<Book> books;

    public Author() {
        
    }

    public Author(String name) {
        this.setName(name);
        this.books = new HashSet<Book>();
        
    }

    /**
     * @return the book
     */
    public Set<Book> getBooks() {
        return this.books;
    }

    /**
     * @param book the book to set
     */
    public void setBook(Set<Book> books) {
        this.books = books;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
}