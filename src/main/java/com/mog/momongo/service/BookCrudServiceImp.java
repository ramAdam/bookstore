package com.mog.momongo.service;

import java.util.List;

import com.mog.momongo.entity.Author;
import com.mog.momongo.entity.Book;
import com.mog.momongo.entity.Category;
import com.mog.momongo.repository.AuthorRepository;
import com.mog.momongo.repository.BookRepository;
import com.mog.momongo.repository.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * BookCrudServiceImp
 */
@Service
public class BookCrudServiceImp implements BookCrudServiceInterface {

    @Autowired
    private BookRepository bookrepo;
    @Autowired
    private CategoryRepository catrepo;
    @Autowired AuthorRepository authorRepo;


    @Override
    public void save(String title, String category, String author) {
        
        Category cat = new Category(category);
        catrepo.save(cat);

        Author sheela = new Author(author);
        authorRepo.save(sheela);

        Book book = new Book(title, cat);
        book.addAuthor(sheela);
        


        try {

            bookrepo.save(book);

        } catch (Exception e) {
            
            System.out.println(e.getMessage());
        }
        
    }

    @Override
    public void delete(Book book) {
        try {

            bookrepo.delete(book);

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Book> findBookByAuthor(Author author) {
       
        // return bookrepo.findByAuthors(author);
       return null;
       
    }

    @Override
    public List<Book> findAll() {
        return bookrepo.findAll();
    }

    @Override
    public Book findByTitle(String title) {
        return bookrepo.findByTitle(title);
    }

    

    

    

    
}