package com.mog.momongo.repository;

import java.util.List;

import com.mog.momongo.entity.Address;
// import com.mog.momongo.entity.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * AddressRepository
 */
public interface AddressRepository extends JpaRepository<Address, Long>{

    @Query(value="SELECT * FROM ADDRESS a LEFT JOIN CUSTOMER c ON a.id = c.id ", nativeQuery = true)
    List<Address> FindAllAddresses();

    
}