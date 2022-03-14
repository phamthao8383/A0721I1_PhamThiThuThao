package com.example.demo3.model;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter@Setter
public class Cartltem {
    private long id;
    private String name;
    private String image;
    private int quantity;
    private double price;
    private int discount;

}