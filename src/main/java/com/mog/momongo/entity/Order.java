package com.mog.momongo.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

/**
 * Order
 */
@Entity
public class Order extends AbstractEntity{

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;
    
    @OneToMany(orphanRemoval = true)
    private List<LineItem> lineItems = new ArrayList<LineItem>();
    
    @NotNull
    @ManyToOne
    private Address shippingAddress;
    

    public Order(Customer customer, Address shippingAddress){
        this.shippingAddress = shippingAddress;
        this.customer = customer;
    }

    protected Order(){

    }

    public void addLineItem(@NotNull LineItem lineItem){
        this.addLineItem(lineItem);
    }

    public List<LineItem> getLineItems(){
        return Collections.unmodifiableList(this.lineItems);
    }

    
}