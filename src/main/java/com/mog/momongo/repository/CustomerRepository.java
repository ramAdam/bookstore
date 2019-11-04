package com.mog.momongo.repository;

import java.util.Set;

import com.mog.momongo.entity.Address;
import com.mog.momongo.entity.Customer;
import com.mog.momongo.entity.Order;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * CustomerRepository
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findByLastName(String name);
    // Set<Address> findAddresses(Customer customer);
    // Set<Order> findAllOrders(String name);
	// Set<Address> findAllAddresses(String string);

    
    
}