package com.mog.momongo.entity;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 * Book
 */
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    // @Basic(fetch=FetchType.LAZY)
    private String title;

    @ManyToOne(fetch=FetchType.EAGER)
    private Category category;

    @ManyToMany(fetch=FetchType.EAGER)
    private Set<Author> authors;

    public Book(){
        this.category = new Category();
    }

    public Book(String title, Category category) {
     
        this.setTitle(title);
        this.authors = new HashSet<Author>();
        this.category = category; 
        
    }

    public void addAuthor(Author author) {
        this.authors.add(author);
    }

    // public Set<Author> getAuthors() {
    //     return this.authors;
    // }

    public String getAuthors(){
        
        return authors.stream()
        .map(a -> a.getName())
        .collect(Collectors.joining(" "));
        
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the reader
     */
    public Category getCategory() {
        return this.category;
    }

    /**
     * @param reader the reader to set
     */
    public void setCategory(Category category) {
        this.category = category;
    }
    
}