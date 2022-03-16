package com.example.quan_ly_khach_hang.service;

import java.util.Optional;

public interface CustomerService<T> {
    Iterable<T> findAll();

    Optional<T> findById(Long id);

    T save(T t);

    void remove(Long id);
}
