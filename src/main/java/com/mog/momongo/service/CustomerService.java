package com.mog.momongo.service;

import java.util.List;
import java.util.Optional;


import com.mog.momongo.entity.Address;
import com.mog.momongo.entity.Customer;
import com.mog.momongo.repository.AddressRepository;
import com.mog.momongo.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * CustomerService
 */
@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepo;

    @Autowired
    private AddressRepository addressRepository;

    public void saveCustomerWithAddress(Customer c, Address address) {
        assert c != null && address != null;

        customerRepo.save(c);

        c.addAddress(address);
        addressRepository.save(address);

    }

    @Transactional(propagation=Propagation.REQUIRED, readOnly=false, noRollbackFor=Exception.class)
    public void addAddress(Long customerId, Address address) {
        
        Optional<Customer> lookup = customerRepo.findById(customerId);
        assert lookup.isPresent();
        
        Customer c = lookup.get();

        c.addAddress(address);
        

	}

    @Transactional(propagation=Propagation.REQUIRED, readOnly=true, noRollbackFor=Exception.class)
	public List<Address> getAllAddressesByCustomerId(Long id) {

        return addressRepository.findAddressesByCustomerId(id);
	}

    
}