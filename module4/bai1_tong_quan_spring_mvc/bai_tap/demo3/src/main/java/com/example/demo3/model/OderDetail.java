package com.example.demo3.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "Orderdetails")
public class OderDetail implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Double price;
    Integer quantity;
    @ManyToOne @JoinColumn(name = "Productid")
    Product product;
    @ManyToOne @JoinColumn(name = "Orderid")
    Order order;
}
