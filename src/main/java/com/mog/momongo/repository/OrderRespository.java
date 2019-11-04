package com.mog.momongo.repository;

import java.util.Set;

import com.mog.momongo.entity.Customer;
import com.mog.momongo.entity.Order;


import org.springframework.data.jpa.repository.JpaRepository;

/**
 * OrderRespository
 */
public interface OrderRespository extends JpaRepository<Order, Long>{

    
    Set<Order> findByCustomer(Customer customer);

    
}