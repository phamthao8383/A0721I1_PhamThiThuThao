package com.example.demo.repository;

import com.example.demo.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//khai báo bean hải có @repository
@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
//    List<Customer> findByNameAndId(String name,Long id);//tu khai bao pthuc
    Page<Customer>findAll(Pageable pageable);
    Page<Customer> findAllByNameContaining(String name, Pageable pageable);

}
