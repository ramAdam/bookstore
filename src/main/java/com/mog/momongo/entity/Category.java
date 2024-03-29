package com.mog.momongo.entity;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Category
 */
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String category;

    @OneToMany(targetEntity=Book.class, mappedBy="category")
    private Collection<Book> books;

    
    public Category() {
        this.category = "";
    }
    



    public Category(String category) {
        this.category = category;
    
    }

    /**
     * @return the category
     */
    public String getCategory() {
        return category;
    }
   

    /**
     * @param category the category to set
     */
    public void setCategory(String category) {
        this.category = category;
    }


}