package com.example.demo3.service;

import com.example.demo3.model.Cartltem;

import java.util.Collection;

public interface ShoppingCartService {


    void add(Cartltem item);

    void remove(int id);

    Collection<Cartltem> getCartItems();

    void clear();

    void update(int id, int quantity);

    double getAmount();

    int getCount();
}
