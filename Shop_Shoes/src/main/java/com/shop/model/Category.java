package com.example.casestudy.model;

import javax.persistence.*;
import java.sql.Date;
import java.time.Instant;
import java.util.Set;

@Entity
@Table(name="category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_category")
    private int idCategory;
    @Column(name = "name")
    private String name;
    private String description;
    @Column(name = "create_at")
    private Instant createdAt;
    @Column(name = "update_at")
    private Instant updatedAt;
    @OneToMany(mappedBy = "id_product")
    private Set<Product> products;

    public Category() {
    }

    public Category(int idCategory, String name, String description, Instant createdAt, Instant updatedAt, Set<Product> products) {
        this.idCategory = idCategory;
        this.name = name;
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.products = products;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
