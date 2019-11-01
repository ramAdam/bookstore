package com.mog.momongo.integration;

import com.mog.momongo.entity.Customer;
import com.mog.momongo.repository.CustomerRepository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * CustomerRepositoryTest
 */
@RunWith(SpringRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@SpringBootTest
public class CustomerRepositoryTest {
    @Autowired
    CustomerRepository repository;


    @Before
    public void setUp(){
        Customer customer = new Customer("ram", "lee");
        customer.setEmailId("abc@bell.net");
        repository.save(customer);
    }

    @Test
    public void saveCustomerTest(){
        Customer customer = repository.getOne(0L);
        assertThat(customer).isNotNull();
    }

    @Test
    public void findCustomerByLastName(){
        Customer customer = repository.findByLastName("lee");
        assertThat(customer).isNotNull();
        assertThat(customer.getLastName()).as("lee");
    }
}
