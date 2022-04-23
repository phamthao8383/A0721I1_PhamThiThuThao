package com.example.casestudy.model;

import javax.persistence.*;

@Entity
@Table(name = "reviews")
public class Reviews {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_reviews")
    private int id;
    private String content;
    private int rate;
    @ManyToOne(targetEntity = User.class)
    private User user;
    @ManyToOne(targetEntity = Product.class)
    private Product product;

    public Reviews() {
    }

    public Reviews(int id, String content, int rate, User user, Product product) {
        this.id = id;
        this.content = content;
        this.rate = rate;
        this.user = user;
        this.product = product;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
