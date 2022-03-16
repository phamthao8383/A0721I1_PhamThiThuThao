package com.example.hoan_thien_gio_hang.service;

import com.example.hoan_thien_gio_hang.model.Product;

import java.util.Optional;

public interface ProductService {
    Iterable<Product> findAll();
    Optional<Product> findById(Long id);
     void addProduct(Product product);

}
