package com.example.casestudy.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IServiceService {
    //    List<com.example.casestudy.model.Service> findAll();
    Page<com.example.casestudy.model.Service> findAll(Pageable pageable);

    Page<com.example.casestudy.model.Service> findAllByNameContaining(String name, Pageable pageable);

    void saveService(com.example.casestudy.model.Service service);//pt thêm mơi và update(tự hieu gióng id la update)

    void deleteService(Long id);

    com.example.casestudy.model.Service findServiceById(Long id);
}
