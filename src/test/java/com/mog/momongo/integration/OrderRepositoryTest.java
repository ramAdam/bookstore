package com.mog.momongo.integration;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Set;

import com.mog.momongo.entity.Address;
import com.mog.momongo.entity.Customer;
import com.mog.momongo.entity.Order;
import com.mog.momongo.repository.CustomerRepository;
import com.mog.momongo.repository.OrderRespository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit4.SpringRunner;



/**
 * OrderRepositoryTest
 */
@RunWith(SpringRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@SpringBootTest
public class OrderRepositoryTest {

    @Autowired
    OrderRespository orderRespository;
    @Autowired
    CustomerRepository customerRepository;

    Customer lee;


    @Before
    public void setUp(){
        // Customer customer = new Customer("ram", "lee");
        // customer.setEmailId("abc@bell.net");

        // customer.addAddress(new Address(196, "Lena cres", "cambridge", "L9T 0Z4"));
        

        // customerRepository.save(customer);
        // Customer lee = customerRepository.findByLastName("lee");
        // assert lee != null ;
        
        // Address shippingAddress =  customer.getAddresses().iterator().next();
        // assert shippingAddress != null;
        
        // Order order = new Order(lee, lee.getAddresses().iterator().next());
        // orderRespository.save(order);
        
    }

    @Test
    public void getOrdersByCustomerTest(){
        // Set<Order> orders = orderRespository.findByCustomer(lee);
        // assertThat(orders).size().isEqualByComparingTo(0);


    }

    
}