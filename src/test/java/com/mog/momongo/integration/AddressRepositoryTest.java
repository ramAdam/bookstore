package com.mog.momongo.integration;

import java.util.List;

import com.mog.momongo.BaseTest;
import com.mog.momongo.entity.Address;
import com.mog.momongo.entity.Customer;
import com.mog.momongo.repository.AddressRepository;
import com.mog.momongo.repository.CustomerRepository;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * AddressRepositoryTest
 */
public class AddressRepositoryTest extends BaseTest{


    @Autowired
    AddressRepository addressRepository;
    @Autowired
    CustomerRepository customerRepository;

    
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
        customerRepository.save(customer);


        Address address = new Address(196, STREET, CITY, POSTAL_CODE);
        customer.addAddress(address);

        addressRepository.save(address);
                
    }

    @Test
    public void getAlladdressLazyLoadingTest(){
        
        Customer customer = customerRepository.findByLastName(LAST_NAME);
        List<Address> addresses = addressRepository.findAddressesByCustomerId(customer.getId());
        Address lena = addresses.get(0);

        assertThat(lena.getPostalCode()).isEqualTo(POSTAL_CODE);
        assertThat(lena.getCity()).isEqualTo(CITY);
        assertThat(lena.getCustomer().getFirstName()).isEqualTo(FIRST_NAME);

        assertThat(lena.getCustomer().getFirstName()).isEqualTo(customer.getFirstName());
    }


    
}