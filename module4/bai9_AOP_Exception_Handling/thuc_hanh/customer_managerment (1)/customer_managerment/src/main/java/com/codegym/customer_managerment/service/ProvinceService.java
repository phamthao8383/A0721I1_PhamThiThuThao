package com.codegym.customer_managerment.service;

import com.codegym.customer_managerment.model.Customer;
import com.codegym.customer_managerment.model.Province;

import java.util.List;

public interface ProvinceService {
    List<Province> findAll();
    void saveProvince(Province province);
    void deleteProvince(Long id);
    Province findProvinceById(Long id);
}
