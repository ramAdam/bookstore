package com.mog.momongo.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 * Address
 */
@Entity
public class Address extends AbstractEntity {

    @NotNull
    private int houseNo;
    @NotNull
    private String streetName, city, postalCode;

    @ManyToOne
    @NotNull
    // @JoinColumn(name="ADD_ID")
    private Customer customer;
    

    public Address(int houseNo, String streetName, String city, String postalCode) {
        
        this.houseNo = houseNo;
        this.streetName = streetName;
        this.city = city;
        this.postalCode = postalCode;
    }

    protected Address(){

    }
   

    public int gethouseNo() {
        return houseNo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public void setHouseNo(int streetNo) {
        this.houseNo = streetNo;
    }

	public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    // @ManyToOne
    // @JoinColumn(name="CUSTOMER_ID")
    public Customer getCustomer(){
        return this.customer;
    }
    
} 