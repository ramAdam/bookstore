package com.mog.momongo.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import com.mog.momongo.entity.Author;
import com.mog.momongo.entity.Book;
import com.mog.momongo.entity.Category;
import com.mog.momongo.repository.AuthorRepository;
import com.mog.momongo.repository.BookRepository;
import com.mog.momongo.repository.CategoryRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * BookData
 */
// @Configuration
// @ComponentScan(basePackages = "com.mog.momongo.data")
@Component("data")
public class BookData implements BooksDataInterface {

    public String art = "Art";

    
    @Autowired
    BookRepository bookrepository;
    @Autowired
    CategoryRepository catRespository;
    @Autowired 
    AuthorRepository authorRepository;

    public BookData() {
        
    }

    @Override
    public void addBook(String category, List<String> authors, String title) {

        Category cat = saveCategory(category);
        List<Author> authList = saveAuthors(authors);
        Book book = saveBook(authList, title, cat);
        


        bookrepository.save(book);

    }

    public void populateBooks(){
        this.addBook("Science", Arrays.asList("Thomas Campbell"), "Big Toe");

        //book 2 
        this.addBook("Philosopy", Arrays.asList("Krishna"), "Freedom from Known");

        this.addBook( art , Arrays.asList("Jhon M. Blanes", "Catherine Jones"), "Art of Doom");
    }

    /**
     * return the list of saved authors
     */
    private List<Author> saveAuthors(List<String> authors){

        List<Author> authList = new ArrayList<Author>();
      
        for(String name: authors){
            Author a = new Author(name);
            authorRepository.save(a);
            authList.add(a);
        }

        return authList;
    }

    /**
     * add authors to the book
     */

     private Book saveBook(List<Author> authors, String title, Category category){

        Book book = new Book(title, category);

        for(Author author: authors){
            book.addAuthor(author);
        }

        return book;

     }
     /**
      * save Category
      */

      private Category saveCategory(String category){
          
        Category cat = new Category(category);
        catRespository.save(cat);
        return cat;
      }
    
}