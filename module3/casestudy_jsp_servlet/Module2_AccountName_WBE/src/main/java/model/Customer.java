package model;

import java.util.Date;

public class Customer {
    private int customerID;
    private String customerName;
    private Date birthDay;
    private byte gender;
    private String idCardPeople;
    private String phoneNumber;
    private String email;
    private String address;
    private int type_customerID;

    public Customer() {
    }

    public Customer( String customerName, Date birthDay, byte gender, String idCardPeople, String phoneNumber, String email, String address, int type_customerID) {
        this.customerName = customerName;
        this.birthDay = birthDay;
        this.gender = gender;
        this.idCardPeople = idCardPeople;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.type_customerID = type_customerID;
    }

    public Customer(int customerID, String customerName, Date birthDay, byte gender, String idCardPeople, String phoneNumber, String email, String address, int type_customerID) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.birthDay = birthDay;
        this.gender = gender;
        this.idCardPeople = idCardPeople;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.type_customerID = type_customerID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public byte getGender() {
        return gender;
    }

    public void setGender(byte gender) {
        this.gender = gender;
    }

    public String getIdCardPeople() {
        return idCardPeople;
    }

    public void setIdCardPeople(String idCardPeople) {
        this.idCardPeople = idCardPeople;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getType_customerID() {
        return type_customerID;
    }

    public void setType_customerID(int type_customerID) {
        this.type_customerID = type_customerID;
    }
}