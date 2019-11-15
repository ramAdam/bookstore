package com.mog.momongo.repository;

import java.util.List;

import com.mog.momongo.entity.Address;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * AddressRepository
 */
public interface AddressRepository extends JpaRepository<Address, Long>{

    // @Query(value="SELECT * FROM ADDRESS a LEFT JOIN CUSTOMER c WHERE c.id = ?1", nativeQuery = true)
    // List<Address> findAddressByCustomerId(Long id);

    // @Query(value="SELECT * FROM ADDRESS a LEFT JOIN CUSTOMER ", nativeQuery = true)
    // List<Address> findAllAddresses()

    @Query(value="Select * FROM Address a WHERE a.cust_id = ?1",
    nativeQuery = true)
    List<Address> findAddressesByCustomerId(Long id);

    @Query(value="Select * FROM Address a WHERE a.cust_id=?1",
    nativeQuery = true)
    List<Address> findByCustomerId(Long id);


    
}