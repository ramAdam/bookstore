package com.mog.momongo.integration;

import com.mog.momongo.data.BookData;
import com.mog.momongo.entity.Author;
import com.mog.momongo.entity.Book;
import com.mog.momongo.repository.BookRepository;

import static org.assertj.core.api.Assertions.tuple;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;


/**
 * BookRepositoryTest
 */
@RunWith(SpringRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@SpringBootTest
public class BookRepositoryTest {

    @Autowired
    BookRepository bookrepository;
    // @Autowired
    // CategoryRepository catRespository;
    // @Autowired 
    // AuthorRepository authorRepository;

    List<Book> books;
  
    @Autowired
    BookData data;

    

    
   	@Before
	public void setUp(){
      
                        
        data.populateBooks();
        books = bookrepository.findAll();

    }

    
    
    @Test
    public void saveBook(){
        
        assertThat(books).size().isGreaterThan(1);
    }
   

    @Test
    public void shouldFindBooksAdded(){
                
        assertThat(books).extracting("title", "category.category")
                                .contains(tuple("Big Toe","Science"));
        // assertThat(filter(books).with("category.category", "art").get()).containsOnly(values)

      
        

        
    }

    @Test
    public void findBookByTitle(){
        
        assertThat(books).size().isGreaterThan(1);
        Book bigToe = this.bookrepository.findByTitle("Big Toe");

        assertThat(bigToe).isNotNull();
        assertThat(bigToe.getTitle()).as("%s wrote", bigToe.getAuthors()).isEqualTo("Big Toe");
        assertThat(bigToe.getAuthors()).size().isEqualTo(1);


        Book freedomFromKnown = bookrepository.findByTitle("Freedom from Known");

        assertThat(freedomFromKnown).isNotNull();
        assertThat(freedomFromKnown.getTitle()).as("%s wrote", freedomFromKnown.getAuthors())
                                               .isEqualTo("Freedom from Known");
        
        assertThat(freedomFromKnown.getAuthors()).size().isEqualTo(1);
        // assertThat(freedomFromKnown.getAuthors()).as("%s written by ", freedomFromKnown.getTitle())
        // .isEqualTo("Krishna");                                               

    }

    @Test
    public void findBookByTitleStartsWithIgnoreCase(){
        Book bigToe = bookrepository.findBookByTitleStartsWithIgnoreCase("Bi"); 
        assertThat(bigToe).isNotNull(); 
        
        assertThat(bigToe.getTitle()).isEqualTo("Big Toe");
        // assertThat(bigToe.getAuthors()).as("Author of %s", bigToe.getTitle()).isEqualTo("Thomas Campbell");
    }


    @Test
    public void findAuthor(){

        
        Book bigToe = books.stream()
        .filter(b -> b.getTitle()
        .equals("Big Toe"))
        .findAny()
        .orElse(null);
        
        // Collection<Author> authors = bigToe.getAuthors();
        Author author = bigToe.getAuthors().stream()
        .filter(a -> a.getName().equals("Thomas Campbell"))
        .findAny()
        .orElse(null);

        assertThat(author).isNotNull();
        assertThat(bigToe.getAuthors()).size().isEqualTo(1);
        assertThat(bigToe.getAuthors()).containsOnly(author);


    }

    @Test
    public void findAllAuthorsOfABook(){

        assertThat(books).size().isGreaterThan(1);

        Book artOfDoom = books.stream().filter(b -> b.getAuthors().size() > 1)
        .findAny()
        .orElse(null);
       
        
        
        Author catherine = artOfDoom.getAuthors().stream()
        .filter(a -> a.getName().equals("Catherine Jones"))
        .findAny()
        .orElse(null);

        Author jhon = artOfDoom.getAuthors().stream()
        .filter(a -> a.getName().equals("Jhon M. Blanes"))
        .findAny()
        .orElse(null);
               
        assertThat(catherine).isNotNull();
        assertThat(jhon).isNotNull();

        //book found
        assertThat(artOfDoom).isNotNull();
        assertThat(artOfDoom.getAuthors()).size().isEqualTo(2);

        
        assertThat(books).flatExtracting("authors")
                                            .contains(catherine, jhon);
   

    }

}
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
