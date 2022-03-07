package com.example.demo.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotEmpty(message = "Tên không được để trống")
    @Size(min=6,max=50, message = "Tên phải nằm trong khoảng 6 đến 50 ký tự")//6 K QUA 50
    private String name;
    @NotEmpty(message = "Địa Chỉ không được để trống")
    @Size(min=6,max=50, message = "Địa Chỉ phải nằm trong khoảng 6 đến 50 ký tự")//6 K QUA 50
    private String address;
@ManyToOne(targetEntity = Province.class)
    private Province province;

    public Customer() {
    }

    public Customer(long id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }
}
