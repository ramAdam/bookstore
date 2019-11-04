package com.mog.momongo.integration;

import com.mog.momongo.entity.Address;
import com.mog.momongo.entity.Customer;
import com.mog.momongo.entity.Order;
import com.mog.momongo.repository.AddressRepository;
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

import java.util.List;
import java.util.Set;

/**
 * CustomerRepositoryTest
 */
@RunWith(SpringRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@SpringBootTest
public class CustomerRepositoryTest {
    @Autowired
    CustomerRepository repository;

    @Autowired
    AddressRepository addressRepository;


    @Before
    public void setUp(){
        Customer customer = new Customer("ram", "lee");
        customer.setEmailId("abc@bell.net");
        repository.save(customer);

        Address address = new Address(196, "Lena cres", "cambridge", "L9T 0Z4");
        address.setCustomer(customer);
        addressRepository.save(address);

        // addressRepository.
        Address repoAddress = addressRepository.findAll().get(0);
        assert repoAddress != null;
        

        // customer.addAddress(address);
        // Address shippingAddress =  customer.getAddresses().iterator().next();
        // assert shippingAddress != null;


        // Order order = new Order(shippingAddress);
        // customer.addOrder(order);
    }

    @Test
    public void saveCustomerTest(){
        Customer customer = repository.getOne(0L);
        assertThat(customer).isNotNull();
        // assertThat(customer.getLastName()).isEqualTo("lee");
    }

    @Test
    public void findCustomerByLastNameTest(){
        Customer customer = repository.findByLastName("lee");
        assertThat(customer).isNotNull();
        assertThat(customer.getLastName()).as("lee");
    }

    @Test
    public void getAlladdressLazyLoadingTest(){
        
        Customer customer = repository.findByLastName("lee");
        List<Address> addresses = addressRepository.findAll();
        Address lena = addresses.get(0);

        assertThat(lena.getPostalCode()).isEqualTo("L9T 0Z4");
        assertThat(lena.getCity()).isEqualTo("cambridge");
        assertThat(lena.getCustomer().getFirstName()).isEqualTo("ram");

        assertThat(lena.getCustomer().getFirstName()).isEqualTo(customer.getFirstName());

        // assertThat(address.getCity()).isEqualTo("cambridge");

    }

    @Test 
    public void findAddressByCustomer(){
        List<Address> addresses = addressRepository.FindAddressesByCustomerName();
        assertThat(addresses).size().isEqualTo(1);
        assertThat(addresses.get(0).getCity()).isEqualTo("cambridge");
    }
    // @Test
    // public void findAllOrdersTest(){
    //     Set<Order> orders = repository.findAllOrders("lee");
    //     assertThat(orders).size().isEqualTo(1);
    // }


}
