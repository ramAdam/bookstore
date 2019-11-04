package com.mog.momongo.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * LineItem
 */
@Entity
public class LineItem extends AbstractEntity {

    @OneToOne
    @JoinColumn(name = "BK_ID")
    private Book book;

    private int quantity;
    private BigDecimal price;

    public LineItem(Book book, int quantity, BigDecimal price) {
        this.book = book;
        this.quantity = quantity;
        this.price = price;
    }

    public LineItem() {
        
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotal(){
        return this.price.multiply(BigDecimal.valueOf(quantity));
    }


    
}