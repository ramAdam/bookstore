package com.mog.momongo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * Address
 */
@Entity
@Table(name="address")
public class Address extends AbstractEntity{
    @NotNull
    private int houseNo;
    @NotNull
    @Column(name = "street")
    private String streetName;
    @NotNull
    private String city, postalCode;

    @ManyToOne()
    @NotNull
    @JoinColumn(name="cust_id")
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

    public Customer getCustomer(){
        return this.customer;
    }
    
} 