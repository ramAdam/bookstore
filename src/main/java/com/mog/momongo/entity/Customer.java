package com.mog.momongo.entity;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

/**
 * Customer
 */
@Entity
public class Customer extends AbstractEntity {

    @NotNull
    private String firstName, lastName;

    @NotNull
    @Column(unique = true)
    private String emailId;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "cust_id")
    private Set<Address> addresses = new HashSet<Address>();

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

    }
    /** public no arg constructor is necessary, otherwise
     *  hibernate throws a bytecode enhancement failed exception
     */
    public Customer(){

    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void add(@NotNull Address address){
        this.addresses.add(address);

    }
    public void setEmailId(String emailID){
        this.emailId = emailID;
    }

    public Set<Address> getAddresses(){
        return Collections.unmodifiableSet(this.addresses);
    }






    
}