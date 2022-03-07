package com.example.demo.service;

import com.example.demo.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerService {
  //  List<Customer>findAll();
    Page<Customer>findAll(Pageable pageable);
    void saveCustomer(Customer customer);//pt thêm mơi và update(tự hieu gióng id la update)
    void deleteCustomer(Long id);
    Customer findCustomerById(Long id);
  Page<Customer> findAllByNameContaining(String name, Pageable pageable);

}
