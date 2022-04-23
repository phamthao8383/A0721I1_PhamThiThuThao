package com.example.casestudy.model;

import javax.persistence.*;

@Entity
@Table(name = "images_product")
public class ImagesProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String path;
    @ManyToOne(targetEntity = Product.class)
    private Product product;

    public ImagesProduct() {
    }

    public ImagesProduct(int id, String name, String path, Product product) {
        this.id = id;
        this.name = name;
        this.path = path;
        this.product = product;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
