package com.example.quan_ly_khach_hang.service;

import com.example.quan_ly_khach_hang.model.Customer;

public interface ICustomerService extends CustomerService{
    Customer save(Customer customer);
}
