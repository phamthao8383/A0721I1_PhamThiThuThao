package com.example.quan_ly_khach_hang.service.impl;

import com.example.quan_ly_khach_hang.model.Customer;
import com.example.quan_ly_khach_hang.repository.CustomerRepository;
import com.example.quan_ly_khach_hang.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public Iterable findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Optional findById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public Object save(Object o) {
        return null;
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void remove(Long id) {
customerRepository.deleteById(id);
    }
}
