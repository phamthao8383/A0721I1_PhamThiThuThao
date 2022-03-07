package com.example.demo.service;

import com.example.demo.model.Province;

import java.util.List;

public interface ProvinceService {
    List<Province> findAll();
    void saveProvince(Province province);//pt thêm mơi và update(tự hieu gióng id la update)
    void deleteProvince(Long id);
    Province findProvinceById(Long id);
}
