package com.example.casestudy.service.impl;

import com.example.casestudy.model.Role;
import com.example.casestudy.repository.RoleRepository;
import com.example.casestudy.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleRepository roleRepository;
    @Override
    public Role findByName(String name) {
        return roleRepository.findByName(name);
    }
}
