package com.codegym.customer_managerment.service.impl;

import com.codegym.customer_managerment.model.Customer;
import com.codegym.customer_managerment.model.Province;
import com.codegym.customer_managerment.repository.ProvinceRepository;
import com.codegym.customer_managerment.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceServiceImpl  implements ProvinceService {
    @Autowired
    ProvinceRepository provinceRepository;
    
    @Override
    public List<Province> findAll() {
        return provinceRepository.findAll();
    }

    @Override
    public void saveProvince(Province province) {
        provinceRepository.save(province);
    }

    @Override
    public void deleteProvince(Long id) {
        provinceRepository.deleteById(id);
    }

    @Override
    public Province findProvinceById(Long id) {
        return provinceRepository.findById(id).orElse(null);
    }
}
