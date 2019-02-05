package com.mog.momongo.integration;

import com.mog.momongo.entity.Author;
import com.mog.momongo.entity.Book;
import com.mog.momongo.entity.Category;
import com.mog.momongo.repository.AuthorRepository;
import com.mog.momongo.repository.BookRepository;
import com.mog.momongo.repository.CategoryRepository;

import org.assertj.core.groups.Tuple;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * BookRepositoryTest
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BookRepositoryTest {

    @Autowired
    BookRepository bookrepository;
    @Autowired
    CategoryRepository catRespository;
    Book book;
    @Autowired AuthorRepository AuthorRepository;

    
   	@Before
	public void setUp(){
        
        Category cat = new Category("Science");
		catRespository.save(cat);

        Author author = new Author("Thomas campbell");
        AuthorRepository.save(author);
        

		book = new Book("Big Toe", cat);
		book.addAuthor(author);

		
    }
    
    @Test
    public void saveBook(){
        bookrepository.save(book);
        assertThat(bookrepository.findAll()).hasSize(1);
    }
   

    @Test
    public void shouldFindBookAdded(){
        bookrepository.save(book);

        assertThat(bookrepository.findAll()).extracting("title", "authors", "category.category")
        .contains(new Tuple("Big Toe", "Thomas campbell", "Science"));

    }
    
}