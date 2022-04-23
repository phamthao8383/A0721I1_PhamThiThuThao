package com.example.casestudy.model;

import javax.persistence.*;

@Entity
@Table(name = "product_size")
public class ProductSize {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int size;
    private int quantity;
    @ManyToOne(targetEntity = Product.class)
    private Product product;

    public ProductSize() {
    }

    public ProductSize(int id, int size, int quantity, Product product) {
        this.id = id;
        this.size = size;
        this.quantity = quantity;
        this.product = product;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
