package com.example.them_san_pham_vao_gio_hang.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Cart {
    private Map<Product,Integer> products = new HashMap<>();

    public Cart() {
    }

    public Cart(Map<Product,Integer> products) {
        this.products = products;
    }

    public Map<Product,Integer> getProducts() {
        return products;
    }
//kiem tra sp có trong giỏ hàng chưa
    private boolean checkItemInCart(Product product){
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            if(entry.getKey().getId().equals(product.getId())){
                return true;
            }
        }
        return false;
    }

    private Map.Entry<Product, Integer> selectItemInCart(Product product){
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            if(entry.getKey().getId().equals(product.getId())){
                return entry;
            }
        }
        return null;
    }
// thêm sp vào gio
    public void addProduct(Product product){
        if (!checkItemInCart(product)){
            products.put(product,1);
        } else {
            Map.Entry<Product, Integer> itemEntry = selectItemInCart(product);
            Integer newQuantity = itemEntry.getValue() + 1;
            products.replace(itemEntry.getKey(),newQuantity);
        }
    }
    public void downItem(Product product){
        if (checkItemInCart(product)){
            Map.Entry<Product, Integer> entry = selectItemInCart(product);
            if (entry.getValue()>1) {
                Integer count = entry.getValue() - 1;
                products.replace(entry.getKey(), count);
            }
        }
    }
    public void deleteById(Long id){
        for (Map.Entry<Product, Integer> entry : products.entrySet()){
            if (entry.getKey().getId().equals(id)){
                products.remove(entry.getKey());
            }
        }
    }


//đếm số lượng sp
    public Integer countProductQuantity(){
        Integer productQuantity = 0;
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            productQuantity += entry.getValue();
        }
        return productQuantity;
    }

    public Integer countItemQuantity(){
        return products.size();
    }
//tiền
    public Float countTotalPayment(){
        float payment = 0;
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            payment += entry.getKey().getPrice() * (float) entry.getValue();
        }
        return payment;
    }
}