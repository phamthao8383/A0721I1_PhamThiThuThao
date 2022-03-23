package com.example.casestudy.service;

import com.example.casestudy.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();
    void saveCustomer(Customer customer);//pt thêm mơi và update(tự hieu gióng id la update)
    void deleteCustomer(Long id);
    Customer findCustomerById(Long id);
}
