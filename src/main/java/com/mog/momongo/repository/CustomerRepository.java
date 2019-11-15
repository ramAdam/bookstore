package com.mog.momongo.repository;

import java.util.List;
import java.util.Optional;

import com.mog.momongo.entity.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * CustomerRepository
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findByLastName(String name);
    
    Customer findByFirstName(String firstName);
        
    @Query(value="Select * from Customer c LEFT JOIN address a ON c.id = a.id AND a.street = ?1", 
    nativeQuery = true )
    List<Customer> findCustomerByAddressStreet(String street);

    
    
    

    
    
}