package com.mog.momongo;



import com.mog.momongo.entity.Book;
import com.mog.momongo.repository.AuthorRepository;
import com.mog.momongo.repository.BookRepository;
import com.mog.momongo.repository.CategoryRepository;
import com.mog.momongo.service.BookCrudServiceImp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MomongoApplication implements CommandLineRunner{

	private static final Logger log = LoggerFactory.getLogger(MomongoApplication.class);
	
	
	@Autowired
	BookRepository bookRepository;

	@Autowired
	AuthorRepository authorRepository;

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	BookCrudServiceImp bookservice;

	public static void main(String[] args) {
		SpringApplication.run(MomongoApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {

		// Category science = new Category("science");
		// categoryRepository.save(science);

		// Author blonski = new Author("blonski");
		// Author sheela = new Author("sheela");

		// authorRepository.save(blonski);
		// authorRepository.save(sheela);

		// Book bigToe = new Book("bigToe", science);
		// bigToe.setCategory(science);
		// bigToe.addAuthor(sheela);
		// bigToe.addAuthor(blonski);

		// Book artOfLiving = new Book("artOfLiving", science);
		// artOfLiving.addAuthor(blonski);

		
		

		// bookRepository.save(bigToe);
		// bookRepository.save(artOfLiving);

		// for(Book bk: bookRepository.findByAuthors(sheela)){
		// 	log.info("****** Book name: " + bk.getTitle());
		// 	log.info("*******Book category: " + bk.getCategory().getCategory());
		// 	log.info("****** Book author(s): " + bk.getAuthors());
			
		// }


		// bookservice.save("Big Toe", "Science", "Tom");

		for(Book bk: bookservice.findAll()){
			log.info("****** Book name: " + bk.getTitle());
			log.info("*******Book category: " + bk.getCategory().getCategory());
			log.info("****** Book author(s): " + bk.getAuthors());
			
		}
			

		

	}
}
