package com.mog.momongo.integration;

import java.util.Collection;
import java.util.List;

import com.mog.momongo.data.BookData;
import com.mog.momongo.entity.Author;
import com.mog.momongo.entity.Book;
import com.mog.momongo.repository.AuthorRepository;
import com.mog.momongo.repository.BookRepository;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;


import static org.assertj.core.api.Assertions.assertThat;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit4.SpringRunner;



/**
 * AuthorRepositoryTest
 */
@RunWith(SpringRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@SpringBootTest
public class AuthorRepositoryTest {

    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    BookRepository bookrepository;

    @Autowired
    BookData bookData;

    List<Book> books;
    List<Author> allAuthors;
    

    @Before
    public void setUp(){
        
        

        books = bookrepository.findAll(); 
        allAuthors = authorRepository.findAll();
    
        
        
    }

    
    @Test
    public void findAuthorsByBook(){

        Book artOfDoom = bookrepository.findByTitle("Art of Doom");
        Collection<Author> authors = authorRepository.findByBooks(artOfDoom);
        

        assertThat(authors).isNotNull();
        assertThat(authors).size().isEqualTo(2);

        assertThat(books).size().isGreaterThan(2);
        assertThat(authors).extracting("name").contains("Catherine Jones", "Jhon M. Blanes")
        .doesNotContain("Krishna", "Thomas Campbell");

                
        

    }
}













