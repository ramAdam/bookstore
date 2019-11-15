package com.mog.momongo.integration.service;

import com.mog.momongo.BaseTest;
import com.mog.momongo.entity.Address;
import com.mog.momongo.entity.Customer;
import com.mog.momongo.repository.AddressRepository;
import com.mog.momongo.repository.CustomerRepository;
import com.mog.momongo.service.CustomerService;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;

/**
 * CustomerServiceTest
 */
public class CustomerServiceTest extends BaseTest {

    @Autowired
    CustomerService service;

    @Autowired
    CustomerRepository customerRepo;

    @Autowired
    AddressRepository addressRepo;

    private Customer savedCustomer;
    private Address address, address2;

    private final String ADDRESS_FIELD = "streetName";

    

    @Before
    public void setUp() {

        Customer c = new Customer("Jam", "jelly");
        c.setEmailId("abc@gcc.net");
        address = new Address(222, "jena ave", "lake", "N12 G27");
        address2 = new Address(2020, "Madrid ave", "Nepean", "M13 H72");

        service.saveCustomerWithAddress(c, address);
        savedCustomer = customerRepo.findByFirstName("Jam");
   

    }
    @Test
    public void addAddressByCustomerIdTest(){
        service.addAddress(savedCustomer.getId(), address2);

        List<Address> customerAddresses = addressRepo.findAddressesByCustomerId(savedCustomer.getId());
        assertThat(customerAddresses.size()).isEqualTo(2);

    }

    @Test
    public void saveCustomerWithGivenAddressTest() {

        assertThat(savedCustomer).isNotNull();
        //test not good, hard coded ID
        assertThat(savedCustomer.getId()).isEqualTo(11L);

        assertThat(savedCustomer.getFirstName()).isEqualTo("Jam");
    }

    @Test
    public void findAllCustomerAddressesByIdTest(){
        
        List<Address> addresses = service.getAllAddressesByCustomerId(savedCustomer.getId());
        assertThat(addresses.size()).isEqualTo(1);
        
        assertThat(addresses.get(0)).isEqualToComparingOnlyGivenFields(address, ADDRESS_FIELD);
        assertThat(addresses).containsOnly(address);

    }
}