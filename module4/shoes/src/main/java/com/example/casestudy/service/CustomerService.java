package com.example.casestudy.service;

import com.example.casestudy.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
  //  Iterable<Customer> findAll();
    void saveCustomer(Customer customer);//pt thêm mơi và update(tự hieu gióng id la update)
    void deleteCustomer(Long id);
   // Customer findCustomerById(Long id);
    Optional<Customer>findCustomerById(Long id);
    Page<Customer> findAll(Pageable pageable);
    Page<Customer> findAllByNameContaining(String name, Pageable pageable);


}
