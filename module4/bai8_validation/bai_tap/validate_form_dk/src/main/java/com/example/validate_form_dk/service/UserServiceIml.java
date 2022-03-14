package com.example.validate_form_dk.service;

import com.example.validate_form_dk.model.User;
import com.example.validate_form_dk.reposition.UserReposition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceIml implements UserService{
    @Autowired
    private UserReposition userReposition;
    @Override
    public List<User> findAll() {
        return userReposition.findAll();
    }
}
