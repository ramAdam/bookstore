package com.mog.momongo.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Fetch;

/**
 * Customer
 */
@Entity
@Table(name = "customer")
public class Customer extends AbstractEntity{

    // @Id
    // @GeneratedValue(strategy = GenerationType.AUTO)
    // private Long id;


    @NotNull
    private String firstName, lastName;

    @NotNull
    @Column(unique = true)
    private String emailId;

    // @JoinColumn(name = "ADD_ID")
    @OneToMany(mappedBy= "customer", cascade=CascadeType.ALL, orphanRemoval = true)
    private Set<Address> addresses = new HashSet<Address>();

    // @OneToMany(mappedBy= "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    // private Set<Order> orders = new HashSet<Order>();


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

    public void addAddress(@NotNull Address address){
        address.setCustomer(this);
        getAddresses().add(address);

    }
    // public void addOrder(@NotNull Order order){
    //     this.orders.add(order);
    // }

    public void setEmailId(String emailID){
        this.emailId = emailID;
    }

    
    public Set<Address> getAddresses(){
        return this.addresses;
    }


    /**
     * @return the orders
     */
    // public Set<Order> getOrders() {
    //     return orders;
    // }



    
}