package com.mog.momongo.repository;

import com.mog.momongo.entity.Customer;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * CustomerRepository
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findByLastName(String name);

    
    
}