package com.mog.momongo.entity;

import java.util.Collection;
import java.util.HashSet;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
    @JoinColumn(name="CAT_ID")          // join col is used to override foreign key name on other side
    private Category category;

    
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable( name = "BK_AUTH",
                joinColumns = @JoinColumn(name="BK_ID", referencedColumnName="id"),
                inverseJoinColumns=@JoinColumn(name="AUTH_ID", referencedColumnName="id"))
    private Collection<Author> authors;

    

    public Book(){
        this.category = new Category();
    }

    public Book(String title, Category category, Author...authors) {
     
        this.setTitle(title);
        this.authors = Stream.of(authors).collect(Collectors.toSet());
        this.authors.forEach(a -> a.getBooks().add(this));
        this.category = category; 
        
    }

    public void addAuthor(Author author) {
        this.authors.add(author);
    }

   
    public Collection<Author> getAuthors(){
        
        return this.authors;
        
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

    public void setAuthors(Collection<Author> authors){
        this.authors = authors;
    }
    
}