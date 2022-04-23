package com.example.casestudy.model;

import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Tên không được để trống")
    private String name;
    @NumberFormat
    private int area;
    private double cost;
    @NumberFormat
    private int max_people;
    private String standard_room;
    @NotEmpty(message = "Description không được để trống")
    private String description;
    private double pool_area;
    @NumberFormat
    private int number_floor;
    @ManyToOne(targetEntity = ServiceType.class)
    private ServiceType serviceType;
    @ManyToOne(targetEntity = RentType.class)
    private RentType rentType;


    public Service() {
    }

    public Service(Long id, String name, int area, double cost, int max_people, String standard_room, String description, double pool_area, int number_floor) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.max_people = max_people;
        this.standard_room = standard_room;
        this.description = description;
        this.pool_area = pool_area;
        this.number_floor = number_floor;
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

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getMax_people() {
        return max_people;
    }

    public void setMax_people(int max_people) {
        this.max_people = max_people;
    }

    public String getStandard_room() {
        return standard_room;
    }

    public void setStandard_room(String standard_room) {
        this.standard_room = standard_room;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPool_area() {
        return pool_area;
    }

    public void setPool_area(double pool_area) {
        this.pool_area = pool_area;
    }

    public int getNumber_floor() {
        return number_floor;
    }

    public void setNumber_floor(int number_floor) {
        this.number_floor = number_floor;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }
}
