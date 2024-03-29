package com.mog.momongo.integration;

import static org.assertj.core.api.Assertions.assertThat;

import com.mog.momongo.BaseTest;
import com.mog.momongo.entity.Address;
import com.mog.momongo.entity.Customer;
import com.mog.momongo.repository.AddressRepository;
import com.mog.momongo.repository.CustomerRepository;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * CustomerRepositoryTest
 */
public class CustomerRepositoryTest extends BaseTest{
    @Autowired
    CustomerRepository repository;

    @Autowired
    AddressRepository addressRepository;

    private String STREET = "SCOTT AVE";
    private String CITY = "ORBIT CITY";
    private String POSTAL_CODE = "J2P 8P7";

    private String FIRST_NAME = "jetson";
    private String LAST_NAME = "vander";
    private String EMAIL_ID = "jetsons@orbit.net";




    @Before
    public void setUp(){
        Customer customer = new Customer(FIRST_NAME, LAST_NAME);
        customer.setEmailId(EMAIL_ID);
        repository.save(customer);


        Address address = new Address(196, STREET, CITY, POSTAL_CODE);
        customer.addAddress(address);

        addressRepository.save(address);
                
    }

    @Test
    public void findCustomerByLastNameTest(){
        Customer customer = repository.findByLastName(LAST_NAME);
        assertThat(customer).isNotNull();
        assertThat(customer.getLastName()).as(LAST_NAME);
    }

   
    
    

}
