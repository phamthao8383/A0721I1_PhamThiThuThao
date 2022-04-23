package com.example.casestudy.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_product")
    private int id;
    private String name;
    private String avatar;
    private String description;
    private Date expiry;
    private double price;
    private int status;
    @ManyToOne(targetEntity = Category.class)
    private Category category;
    @OneToMany(mappedBy = "id")
    private Set<ProductSize> productSizes;
    @OneToMany(mappedBy = "id")
    private Set<ImagesProduct> imagesProducts;
    @OneToMany(mappedBy = "id")
    private Set<Reviews> reviews;
    @OneToMany(mappedBy = "id")
    private Set<OrderDetail> orderDetails;
    public Product() {
    }

    public Product(int id, String name, String avatar, String description, Date expiry, double price, int status, Category category, Set<ProductSize> productSizes, Set<ImagesProduct> imagesProducts, Set<Reviews> reviews) {
        this.id = id;
        this.name = name;
        this.avatar = avatar;
        this.description = description;
        this.expiry = expiry;
        this.price = price;
        this.status = status;
        this.category = category;
        this.productSizes = productSizes;
        this.imagesProducts = imagesProducts;
        this.reviews = reviews;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(Set<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getExpiry() {
        return expiry;
    }

    public void setExpiry(Date expiry) {
        this.expiry = expiry;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<ProductSize> getProductSizes() {
        return productSizes;
    }

    public void setProductSizes(Set<ProductSize> productSizes) {
        this.productSizes = productSizes;
    }

    public Set<ImagesProduct> getImagesProducts() {
        return imagesProducts;
    }

    public void setImagesProducts(Set<ImagesProduct> imagesProducts) {
        this.imagesProducts = imagesProducts;
    }

    public Set<Reviews> getReviews() {
        return reviews;
    }

    public void setReviews(Set<Reviews> reviews) {
        this.reviews = reviews;
    }
}
