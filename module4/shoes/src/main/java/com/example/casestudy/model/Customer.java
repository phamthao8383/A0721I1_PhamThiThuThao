package com.example.casestudy.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.sql.Date;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @NotNull(message = "K được trống")
//    @Pattern(regexp = "^$|[0-9]")
    private Long id;
   // @NotNull
    private String name;
    //@NotNull
    private Date birthday;
    private String gender;
   // @NotNull
   // @Pattern(regexp = "^[a-z][a-z0-9_\\.]{5,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$")
    private String email;
    //@Pattern(regexp = "/((09|03|07|08|05)+([0-9]{8})\\b)/g")
    private String phone;
  //  @NotNull(message = "không được trống")
   // @Pattern(regexp = "^\\d+\\s[A-z]+\\s[A-z]+")
    private String address;
    @ManyToOne(targetEntity = CustomerType.class)
    private CustomerType customerType;
    public Customer() {
    }
    public Customer(Long id, String name, Date birthday, String gender, String email, String phone, String address) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }
}
