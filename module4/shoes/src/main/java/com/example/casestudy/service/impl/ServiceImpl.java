package com.example.casestudy.service.impl;

import com.example.casestudy.repository.ServiceRepository;
import com.example.casestudy.service.IServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ServiceImpl implements IServiceService {
    @Autowired
    private ServiceRepository serviceRepository;


    @Override
    public Page<com.example.casestudy.model.Service> findAll(Pageable pageable) {
        return serviceRepository.findAll(pageable);
    }

    @Override
    public Page<com.example.casestudy.model.Service> findAllByNameContaining(String name, Pageable pageable) {
        return serviceRepository.findAllByNameContaining(name,pageable);
    }
    @Override
    public void saveService(com.example.casestudy.model.Service service) {
        serviceRepository.save(service);
    }
    @Override
    public void deleteService(Long id) {
        serviceRepository.deleteById(id);
    }
    @Override
    public com.example.casestudy.model.Service findServiceById(Long id) {
        return serviceRepository.findById(id).orElse(null);
    }
}
