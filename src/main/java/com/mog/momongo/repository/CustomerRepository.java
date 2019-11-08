package com.mog.momongo.repository;

import java.util.List;

import com.mog.momongo.entity.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * CustomerRepository
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findByLastName(String name);
        
    @Query(value="Select * from Customer c LEFT JOIN address a ON c.id = a.id AND a.street = ?1", 
    nativeQuery = true )
    List<Customer> findCustomerByAddressStreet(String street);

    Customer findByFirstName(String firstName);

    
        
    // Set<Order> findAllOrders(String name);
    // Set<Address> findAllAddresses(String string);
    
    

    
    
}