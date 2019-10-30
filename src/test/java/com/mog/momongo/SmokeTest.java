package com.mog.momongo;

import com.mog.momongo.repository.BookRepository;
import com.mog.momongo.repository.CategoryRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;



@RunWith(SpringRunner.class)
@SpringBootTest
public class SmokeTest {

	@Autowired
	BookRepository repository;
	@Autowired
	CategoryRepository catRepository;
	String title;

	
	@Test
	public void contextLoads() {
		assertThat(repository).isNotNull();
	}


	
}
