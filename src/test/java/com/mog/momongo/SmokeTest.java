package com.mog.momongo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import com.mog.momongo.entity.Customer;
import com.mog.momongo.repository.BookRepository;
import com.mog.momongo.repository.CategoryRepository;
import com.mog.momongo.repository.CustomerRepository;

import org.hibernate.LazyInitializationException;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class SmokeTest extends BaseTest{

	@Autowired
	BookRepository repository;
	@Autowired
	CategoryRepository catRepository;
	String title;

	@Autowired
	CustomerRepository customerRepository;

	
	@Test
	public void contextLoads() {
		assertThat(repository).isNotNull();
	}

	
}
